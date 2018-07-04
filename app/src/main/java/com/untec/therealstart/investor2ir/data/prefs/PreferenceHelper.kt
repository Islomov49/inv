package com.untec.therealstart.investor2ir.data.prefs

interface PreferenceHelper {
    companion object {
        const val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        const val PREF_KEY_REFRESH_TOKEN = "PREF_KEY_REFRESH_TOKEN"
        const val EXPERED_TIME = "EXPERED_TIME"

    }

    fun getExperedTime(): Long
    fun setExperedTime(experedTime: Long)
    fun getReshreshToken(): String
    fun setRefreshToken(refreshToken: String)
    fun getAccessToken(): String
    fun setAccessToken(accessToken: String)

}