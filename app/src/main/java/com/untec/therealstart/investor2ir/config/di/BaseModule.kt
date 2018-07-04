package com.untec.therealstart.investor2ir.config.di

import android.app.Application
import android.content.Context
import com.untec.therealstart.investor2ir.data.DatabaseManager
import com.untec.therealstart.investor2ir.data.DatabaseManagerImpl
import com.untec.therealstart.investor2ir.data.InvDatabase
import com.untec.therealstart.investor2ir.data.db.LocalDatabase
import com.untec.therealstart.investor2ir.data.db.LocalDatabaseImpl
import com.untec.therealstart.investor2ir.data.network.ApiDatabase
import com.untec.therealstart.investor2ir.data.network.ApiDatabaseImpl
import com.untec.therealstart.investor2ir.data.network.oauth2.GetOauthTokenUseCase
import com.untec.therealstart.investor2ir.data.network.oauth2.OAuth2ApiService
import com.untec.therealstart.investor2ir.data.prefs.PreferenceHelper
import com.untec.therealstart.investor2ir.data.prefs.PreferenceHelperImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class BaseModule {
    @Provides
    @Singleton
    fun provideDatabaseManager(localDatabase: LocalDatabase,apiDatabase: ApiDatabase,preferenceHelper: PreferenceHelper):DatabaseManager =
        DatabaseManagerImpl(localDatabase,apiDatabase,preferenceHelper)

    @Provides
    @Singleton
    fun providePreferenceHelper(context: Application):PreferenceHelper = PreferenceHelperImpl(context)

    @Provides
    @Singleton
    fun provideLocalDatabase(invDatabase: InvDatabase,preferenceHelper: PreferenceHelper):LocalDatabase = LocalDatabaseImpl(invDatabase,preferenceHelper)

    @Provides
    @Singleton
    fun provideApiDatabase(oAuth2ApiService: OAuth2ApiService,getOauthTokenUseCase: GetOauthTokenUseCase,retrofit: Retrofit):ApiDatabase =
            ApiDatabaseImpl(oAuth2ApiService,getOauthTokenUseCase,retrofit)


}