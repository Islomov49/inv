package com.untec.therealstart.investor2ir.data.network

import com.untec.therealstart.investor2ir.BuildConfig

object ApiEndPoint{

    val ENDPOINT_GET_VERIFICATION_CODE = BuildConfig.BASE_URL + "/registrations/requests"
    val ENDPOINT_GET_REGISTRATION_TOKEN = BuildConfig.BASE_URL + "/registrations/tokens"
    val ENDPOINT_REGISTRATION_USER = BuildConfig.BASE_URL + "/registrations"

}