package com.untec.therealstart.investor2ir

import android.app.Activity
import android.app.Application
import android.arch.persistence.room.Room
import com.untec.therealstart.investor2ir.common.InvDatabase
import com.untec.therealstart.investor2ir.config.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AppInv: Application(), HasActivityInjector {
    companion object {
        var database: InvDatabase? = null
    }

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInv.database =  Room.databaseBuilder(this, InvDatabase::class.java, "inv.db").build()
        DaggerApplicationComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}