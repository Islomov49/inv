package com.untec.therealstart.investor2ir.ui.singin

import android.support.v7.app.AppCompatActivity
import com.untec.therealstart.investor2ir.config.di.scope.PerActivity
import com.untec.therealstart.investor2ir.config.di.scope.PerFragment
import com.untec.therealstart.investor2ir.ui.singin.example.InvestorFragment
import com.untec.therealstart.investor2ir.ui.singin.example.InvestorFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class InvestorActivityModule {

    @Binds
    @PerActivity
    internal abstract fun provideConsignmentActivity(investorActivity: InvestorActivity): AppCompatActivity

    @PerFragment
    @ContributesAndroidInjector(modules = [(InvestorFragmentModule::class)])
    internal abstract fun contributeInvestorFragment(): InvestorFragment
}