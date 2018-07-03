package com.untec.therealstart.investor2ir.ui.singin.example

import com.untec.therealstart.investor2ir.config.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ExamplePresenterModule {

    @Binds
    @PerFragment
    abstract fun provideExamplePresenter(examplePresenter: ExamplePresenter) : ExampleContract.Presenter
}