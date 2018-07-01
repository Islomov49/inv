package com.untec.therealstart.investor2ir

import android.app.Application
import android.arch.persistence.room.Room
import com.untec.therealstart.investor2ir.common.InvDatabase

class AppInv: Application(){
    companion object {
        var database: InvDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        AppInv.database =  Room.databaseBuilder(this, InvDatabase::class.java, "inv.db").build()
    }
}