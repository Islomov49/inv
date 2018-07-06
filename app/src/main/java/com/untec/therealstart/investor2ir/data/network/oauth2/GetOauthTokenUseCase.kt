package com.untec.therealstart.investor2ir.data.network.oauth2

import com.untec.therealstart.investor2ir.data.network.model.TokenResponse
import com.untec.therealstart.investor2ir.data.prefs.PreferenceHelper
import io.reactivex.schedulers.Schedulers
import okhttp3.Credentials
import java.util.*

class GetOauthTokenUseCase(val mOauthApiService: OAuth2ApiService, private val preferencesHelper: PreferenceHelper) {

    fun login() {
        val authorizationHeader = Credentials.basic("161885999778BEF863FE37D193F7A", "DEBFFCA522369CB7245E15CDCDBD1")
        val map = HashMap<String,String>()
        map["grant_type"] = "password"
        map["username"] = "name"
        map["password"] = "123"

        val tokenResponse = mOauthApiService.getToken(map, authorizationHeader)
                .subscribeOn(Schedulers.io()).blockingGet()

        preferencesHelper.setAccessToken(tokenResponse.accessToken)
        preferencesHelper.setRefreshToken(tokenResponse.refreshToken)
    }

    fun reshreshToken(): TokenResponse {
        val authorizationHeader = Credentials.basic("161885999778BEF863FE37D193F7A", "DEBFFCA522369CB7245E15CDCDBD1")
        return mOauthApiService.refreshToken(preferencesHelper.getReshreshToken(), authorizationHeader).subscribeOn(Schedulers.io()).blockingGet()
    }
}