package com.untec.therealstart.investor2ir.data.prefs

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelperImpl(context: Context):PreferenceHelper {

    private var preferences: SharedPreferences = context.getSharedPreferences(PreferenceHelper.PREFERENCE_PATH,Context.MODE_PRIVATE)

    override fun getSomeThink() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}