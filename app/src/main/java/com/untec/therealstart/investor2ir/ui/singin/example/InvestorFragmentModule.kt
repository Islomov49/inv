package com.untec.therealstart.investor2ir.ui.singin.example

import android.support.v4.app.Fragment
import com.untec.therealstart.investor2ir.config.di.scope.PerFragment
import dagger.Binds
import dagger.Module

@Module(includes = [(ExamplePresenterModule::class)])
abstract class InvestorFragmentModule {

    @Binds
    @PerFragment
    abstract fun provideFragment(fragment: InvestorFragment): Fragment

    @Binds
    @PerFragment
    abstract fun provideExampleView(fragment: InvestorFragment) : ExampleContract.View
}