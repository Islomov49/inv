package com.untec.therealstart.investor2ir.data.network.model

import com.google.gson.annotations.SerializedName

data class RegistrationTokenResponse(
        @SerializedName("token") val registrationToken: String,
        @SerializedName("date_granted") val grantedDate: String,
        @SerializedName("expires_in") val expiresIn: Long
        )