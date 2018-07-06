package com.untec.therealstart.investor2ir.data.network.model

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("expires_in") val expiredTime: Long ,
    @SerializedName("token_type")  val tokenType: String,
    @SerializedName("refresh_token") val refreshToken: String
)
