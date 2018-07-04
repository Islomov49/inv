package com.untec.therealstart.investor2ir.data.network.api

import io.reactivex.Single
import junit.framework.Test
import retrofit2.http.GET

interface RegistrationApi{
    @GET("/test")
    fun getTests(): Single<List<Test>>
}