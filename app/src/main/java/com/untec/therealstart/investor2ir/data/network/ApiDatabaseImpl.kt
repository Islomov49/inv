package com.untec.therealstart.investor2ir.data.network

import com.untec.therealstart.investor2ir.data.network.oauth2.GetOauthTokenUseCase
import com.untec.therealstart.investor2ir.data.network.oauth2.OAuth2ApiService
import retrofit2.Retrofit

class ApiDatabaseImpl (oAuth2ApiService: OAuth2ApiService, getOauthTokenUseCase: GetOauthTokenUseCase, retrofit: Retrofit ): ApiDatabase{

}