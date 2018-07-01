package com.untec.therealstart.investor2ir.data.db.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.untec.therealstart.investor2ir.common.BaseDao

@Entity
data class Example(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val firstName: String,
        val secondName: String
)