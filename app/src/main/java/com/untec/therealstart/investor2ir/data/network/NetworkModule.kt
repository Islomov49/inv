package com.untec.therealstart.investor2ir.data.network

import com.untec.therealstart.investor2ir.BuildConfig.BASE_URL
import com.untec.therealstart.investor2ir.data.network.api.RegistrationApi
import com.untec.therealstart.investor2ir.data.network.oauth2.GetOauthTokenUseCase
import com.untec.therealstart.investor2ir.data.network.oauth2.OAuth2ApiService
import com.untec.therealstart.investor2ir.data.network.oauth2.TokenAuthentificator
import com.untec.therealstart.investor2ir.data.network.oauth2.TokenInterceptor
import com.untec.therealstart.investor2ir.data.prefs.PreferenceHelper
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {
    companion object {
        const val CONNECT_TIME_OUT: Long = 3 * 1000 //3 second
        const val READ_TIME_OUT: Long = 3 * 1000 //3 second
        const val WRITE_TIME_OUT: Long = 3 * 1000 //3 second
    }

    @Provides
    @Singleton
    internal fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    @Provides
    @Singleton
    internal fun provideRegistrationApi(retrofit: Retrofit): RegistrationApi {
        return retrofit.create(RegistrationApi::class.java)
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(tokenAuthentificator: TokenAuthentificator, tokenInterceptor: TokenInterceptor): OkHttpClient {
        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1

        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.authenticator(tokenAuthentificator)
        okhttpClientBuilder.addInterceptor(tokenInterceptor)
        okhttpClientBuilder.dispatcher(dispatcher)
        okhttpClientBuilder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
        return okhttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideTokenAuthenticator(getOauthTokenUseCase: GetOauthTokenUseCase, preferencesHelper: PreferenceHelper): TokenAuthentificator {
        return TokenAuthentificator(getOauthTokenUseCase, preferencesHelper)
    }

    @Provides
    @Singleton
    fun provideTokenInterceptor(preferencesHelper: PreferenceHelper, getOauthTokenUseCase: GetOauthTokenUseCase): TokenInterceptor {
        return TokenInterceptor(preferencesHelper, getOauthTokenUseCase)
    }

    @Provides
    @Singleton
    fun provideGetOauthTokenUseCase(auth2ApiService: OAuth2ApiService, preferencesHelper: PreferenceHelper): GetOauthTokenUseCase {
        return GetOauthTokenUseCase(auth2ApiService, preferencesHelper)
    }

    @Provides
    @Singleton
    fun provideOAuth2ApiService(): OAuth2ApiService {
        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.dispatcher(dispatcher)
        okhttpClientBuilder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
        val retrofit = provideRetrofitInterface(okhttpClientBuilder.build())
        return retrofit.create(OAuth2ApiService::class.java!!)
    }




}