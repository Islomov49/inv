package com.untec.therealstart.investor2ir.data.network

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response

interface ApiDatabase {
    fun getVerificationCode(email: String): Single<Void>
}