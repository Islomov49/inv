package com.untec.therealstart.investor2ir.data.db.example

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.untec.therealstart.investor2ir.common.BaseDao
import io.reactivex.Single

@Dao
abstract class ExampleDao:BaseDao<Example>(){
    @Query("SELECT * FROM Example WHERE id = :id")
    abstract fun findById(id: Long): Single<Example>
    @Query("SELECT * FROM Example")
    abstract fun getAll(): Single<List<Example>>
}