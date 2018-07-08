package com.untec.therealstart.investor2ir.data.network.api

import com.untec.therealstart.investor2ir.data.network.model.RegistrationTokenResponse
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegistrationApi{

    // DOCUMENTATION SOURCE : https://wiki.investor2ir.therealstart.com/Resource_Register.html
    @FormUrlEncoded
    @POST("/registrations/requests")
    fun getVerificationCode(
            @Field("client_id") clientId: String,
            @Field("client_secret") clientSecret: String,
            @Field("email") email: String
                ): Single<Void>

    @FormUrlEncoded
    @POST("/registrations/tokens")
    fun getRegistrationToken(
            @Field("email") email: String,
            @Field("client_id") clientId: String,
            @Field("client_secret") clientSecret: String,
            @Field("code") code: String
    ) : Single<RegistrationTokenResponse>

    @FormUrlEncoded
    @POST("/registrations")
    fun registerUser(
            @Field("registration_token")  registration_token:String,
            @Field("type") type: Int,
            @Field("first_name") firstName: String,
            @Field("last_name") lastName: String,
            @Field("position") position: Int,
            @Field("investment_focus") investmentFocus: Int,
            @Field("investment_style") investmentStyle: Int,
            @Field("geographic_focus") geographicFocus: Int,
            @Field("sector_focus") sectorFocus: Int,
            @Field("personal_email") personalEmail: String? = null,
            @Field("position_details") positionDetial:  Int? = null,
            @Field("investment_focus_comment") investmentFocusComment: String? = null,
            @Field("investment_style_comment") investmentStyleComment: String? = null,
            @Field("geographic_focus_comment") geographicFocusComment: String? = null,
            @Field("sector_focus_comment") sectorFocusComment: String? = null
     ) : Single<ResponseBody>
}