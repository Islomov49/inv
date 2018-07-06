package com.untec.therealstart.investor2ir.data.network

import android.util.Log
import com.untec.therealstart.investor2ir.BuildConfig
import com.untec.therealstart.investor2ir.data.network.api.RegistrationApi
import com.untec.therealstart.investor2ir.data.network.oauth2.GetOauthTokenUseCase
import com.untec.therealstart.investor2ir.data.network.oauth2.OAuth2ApiService
import com.untec.therealstart.investor2ir.utils.ValidorUtils
import io.reactivex.Single
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit

class ApiDatabaseImpl (oAuth2ApiService: OAuth2ApiService, getOauthTokenUseCase: GetOauthTokenUseCase, retrofit: Retrofit ): ApiDatabase{
    val registrationApi = retrofit.create(RegistrationApi::class.java)

    override fun getVerificationCode(email: String): Single<Void> {
        check(ValidorUtils.isEmailValid(email))
        return Single.create {
            registrationApi.getVerificationCode(
                    clientId = BuildConfig.CLIENT_ID,
                    clientSecret = BuildConfig.CLIENT_SECRET,
                    email = email)
                    .subscribe(
                        {
                            Log.e("RESPONSE_TEST",it.code().toString())
                        },{
                            if(it is HttpException){
                                Log.e("RESPONSE_TEST",it.code().toString() + "  CAUSE: " + it.message)
                            }
                        }
                    )
        }
    }




}