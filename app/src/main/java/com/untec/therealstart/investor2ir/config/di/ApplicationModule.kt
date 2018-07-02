package com.untec.therealstart.investor2ir.config.di

import android.app.Application
import com.untec.therealstart.investor2ir.AppInv
import com.untec.therealstart.investor2ir.config.di.scope.PerActivity
import com.untec.therealstart.investor2ir.ui.singin.InvestorActivity
import com.untec.therealstart.investor2ir.ui.singin.InvestorActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class ApplicationModule {
    internal abstract fun application(app: AppInv): Application

    @PerActivity
    @ContributesAndroidInjector(modules = [(InvestorActivityModule::class)])
    internal abstract fun contributeInvestorActivity(): InvestorActivity

}