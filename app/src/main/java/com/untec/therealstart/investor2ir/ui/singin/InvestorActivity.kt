package com.untec.therealstart.investor2ir.ui.singin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.untec.therealstart.investor2ir.AppInv
import com.untec.therealstart.investor2ir.R
import com.untec.therealstart.investor2ir.data.db.model.Example
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class InvestorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investor)

        //Example code for working with ROOM
        val example = Example(0,"Sardor","Islomov")
        Single.fromCallable({
            AppInv.database?.exampleDao()?.insert(example)
        }).subscribeOn(Schedulers.io()).subscribe({
            AppInv.database?.exampleDao()?.getAll()?.subscribe({
                Log.d("room_test","READ SUCCESS: " + it.toString())
            },{
                Log.d("room_test",it.message)
            })
        },{
            Log.d("room_test",it.message)

        })


    }
}
