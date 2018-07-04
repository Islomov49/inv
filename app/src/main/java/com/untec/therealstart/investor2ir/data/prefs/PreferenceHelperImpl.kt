package com.untec.therealstart.investor2ir.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.untec.therealstart.investor2ir.BuildConfig
import com.untec.therealstart.investor2ir.data.prefs.PreferenceHelper.Companion.EXPERED_TIME
import com.untec.therealstart.investor2ir.data.prefs.PreferenceHelper.Companion.PREF_KEY_ACCESS_TOKEN
import com.untec.therealstart.investor2ir.data.prefs.PreferenceHelper.Companion.PREF_KEY_REFRESH_TOKEN

class PreferenceHelperImpl(context: Context):PreferenceHelper {
    var mPrefs: SharedPreferences = context.getSharedPreferences(BuildConfig.BASE_XML, Context.MODE_PRIVATE)

    override fun setAccessToken(accessToken: String) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN,accessToken).apply()
    }

    override fun setExperedTime(experedTime: Long) {
        mPrefs.edit().putLong(EXPERED_TIME,experedTime).apply()
    }

    override fun getReshreshToken(): String {
        return mPrefs.getString(PREF_KEY_REFRESH_TOKEN,"")
    }

    override fun setRefreshToken(refreshToken: String) {
        mPrefs.edit().putString(PREF_KEY_REFRESH_TOKEN,refreshToken).apply()
    }

    override fun getAccessToken(): String {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN,"")
    }

    override fun getExperedTime(): Long {
        return mPrefs.getLong(EXPERED_TIME,-1)
    }



}