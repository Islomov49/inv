package com.untec.therealstart.investor2ir.common

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.untec.therealstart.investor2ir.data.db.dao.ExampleDao
import com.untec.therealstart.investor2ir.data.db.model.Example

@Database(entities = arrayOf(Example::class),version = 1)
abstract class InvDatabase:RoomDatabase(){
    abstract fun exampleDao(): ExampleDao
}