package com.untec.therealstart.investor2ir.data.network.oauth2

import com.untec.therealstart.investor2ir.data.network.model.TokenResponse
import io.reactivex.Single
import retrofit2.http.*

interface OAuth2ApiService{
    @FormUrlEncoded
    @POST("/oauth/token?grant_type=password")
    @Headers("Accept: application/json")
    fun getToken(@FieldMap map: Map<String, String>, @Header("Authorization") auth: String): Single<TokenResponse>


    @FormUrlEncoded
    @POST("/oauth/token?grant_type=refresh_token")
    @Headers("Accept: application/json")
    fun refreshToken(@Field("refresh_token") refreshToken: String, @Header("Authorization") auth: String): Single<TokenResponse>
}