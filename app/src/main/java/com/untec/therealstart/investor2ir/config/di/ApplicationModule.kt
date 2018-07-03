package com.untec.therealstart.investor2ir.config.di

import android.app.Application
import com.untec.therealstart.investor2ir.AppInv
import com.untec.therealstart.investor2ir.config.di.scope.PerActivity
import com.untec.therealstart.investor2ir.ui.singin.InvestorActivity
import com.untec.therealstart.investor2ir.ui.singin.InvestorActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


@Module
internal abstract class ApplicationModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(InvestorActivityModule::class)])
    internal abstract fun contributeInvestorActivity(): InvestorActivity

}