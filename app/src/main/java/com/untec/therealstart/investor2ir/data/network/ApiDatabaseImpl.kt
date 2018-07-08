package com.untec.therealstart.investor2ir.data.network

import com.untec.therealstart.investor2ir.BuildConfig
import com.untec.therealstart.investor2ir.data.network.api.RegistrationApi
import com.untec.therealstart.investor2ir.utils.ValidorUtils
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit

class ApiDatabaseImpl (retrofit: Retrofit ): ApiDatabase{
    val registrationApi = retrofit.create(RegistrationApi::class.java)

    override fun getVerificationCode(email: String): Single<Void> {
        check(ValidorUtils.isEmailValid(email))
        return registrationApi.getVerificationCode(
                    clientId = BuildConfig.CLIENT_ID,
                    clientSecret = BuildConfig.CLIENT_SECRET,
                    email = email).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }




}