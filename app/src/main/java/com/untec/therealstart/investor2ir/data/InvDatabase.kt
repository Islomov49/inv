package com.untec.therealstart.investor2ir.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.untec.therealstart.investor2ir.data.db.example.ExampleDao
import com.untec.therealstart.investor2ir.data.db.example.Example

@Database(entities = arrayOf(Example::class),version = 1)
abstract class InvDatabase:RoomDatabase(){
    abstract fun exampleDao(): ExampleDao
}