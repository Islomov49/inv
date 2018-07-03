package com.untec.therealstart.investor2ir.config.di

import android.app.Application
import com.untec.therealstart.investor2ir.AppInv
import com.untec.therealstart.investor2ir.data.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (ApplicationModule::class), (DatabaseModule::class    )])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: AppInv)
}