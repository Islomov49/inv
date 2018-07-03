package com.untec.therealstart.investor2ir.data

import android.app.Application
import android.arch.persistence.room.Room
import com.untec.therealstart.investor2ir.data.db.example.ExampleDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DatabaseModule{
    @Singleton
    @Provides
    fun provideInvDatabase(context: Application): InvDatabase {
        return Room.databaseBuilder(
                context,
                InvDatabase::class.java,
                "inv.db").build()
    }

    @Singleton
    @Provides
    fun provideExampleDao(db: InvDatabase) : ExampleDao {
        return db.exampleDao()
    }

}
