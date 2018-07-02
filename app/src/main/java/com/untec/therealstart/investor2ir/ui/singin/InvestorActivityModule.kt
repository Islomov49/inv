package com.untec.therealstart.investor2ir.ui.singin

import android.support.v7.app.AppCompatActivity
import com.untec.therealstart.investor2ir.config.di.scope.PerActivity
import com.untec.therealstart.investor2ir.config.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InvestorActivityModule {

    @Binds
    @PerActivity
    internal abstract fun provideConsignmentActivity(investorActivity: InvestorActivity): AppCompatActivity

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun contributeInvestorFragment(): InvestorFragment
}