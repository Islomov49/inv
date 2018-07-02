package com.untec.therealstart.investor2ir.config.di

import android.app.Application
import com.untec.therealstart.investor2ir.AppInv
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [(AndroidSupportInjectionModule::class), (ApplicationModule::class)])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: AppInv)
}