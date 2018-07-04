package com.untec.therealstart.investor2ir.data.network.oauth2

import com.untec.therealstart.investor2ir.data.prefs.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class TokenInterceptor(private val preferencesHelper: PreferenceHelper, private val getOauthTokenUseCase: GetOauthTokenUseCase) : Interceptor {
    @Synchronized
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var newRequest = chain.request()


        //        //get expire time from shared preferences
        //        long expireTime=preferencesHelper.getExperedTime();
        //
        //
        //        /**
        //         * when comparing dates -1 means date passed so we need to refresh token
        //         * see {@link Date#compareTo}
        //         */
        //        if(expireTime<System.currentTimeMillis()) {
        //            TokenResponse tokenInterceptor =  getOauthTokenUseCase.getObservable().toBlocking().value();
        //            preferencesHelper.setExperedTime(tokenInterceptor.getExpiredTime()*1000+System.currentTimeMillis());
        //
        //            String accessToken = tokenInterceptor.getAccessToken();
        //            Log.d("retrofitoaxuth", "intercept: " + accessToken);
        //            Log.d("retrofitoaxuth", "intercept: " + tokenInterceptor.getRefreshToken());
        //            preferencesHelper.setAccessToken(tokenInterceptor.getAccessToken());
        //            newRequest=chain.request().newBuilder()
        //                    .header("Authorization", tokenInterceptor.getAccessToken())
        //                    .build();
        //        }
        if (!preferencesHelper.getAccessToken().isEmpty())
            newRequest = chain.request().newBuilder()
                    .header("Authorization", String.format("Bearer %s", preferencesHelper.getAccessToken()))
                    .build()
        return chain.proceed(newRequest)
    }
}
