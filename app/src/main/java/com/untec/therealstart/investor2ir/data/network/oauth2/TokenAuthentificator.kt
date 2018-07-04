package com.untec.therealstart.investor2ir.data.network.oauth2

import android.util.Log
import com.untec.therealstart.investor2ir.data.prefs.PreferenceHelper
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import java.io.IOException


class TokenAuthentificator(private val getOauthTokenUseCase: GetOauthTokenUseCase, private val preferencesHelper: PreferenceHelper) : Authenticator {

    init {
        Log.d("retrofitoaxuth", "TokenAuthenticator: ")
    }

    @Throws(IOException::class)
    override fun authenticate(route: Route, response: Response): Request? {

        val value = getOauthTokenUseCase.reshreshToken()
        val accessToken = value.accessToken
        preferencesHelper.setAccessToken(value.accessToken)
        return if (!accessToken.isEmpty())
            response.request().newBuilder()
                    .header("Authorization", String.format("Bearer %s", accessToken))
                    .build()
        else
            null
    }
}