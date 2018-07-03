package com.untec.therealstart.investor2ir.ui.singin

import android.os.Bundle
import android.util.Log
import com.untec.therealstart.investor2ir.R
import com.untec.therealstart.investor2ir.data.db.example.Example
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import com.untec.therealstart.investor2ir.config.base.BaseActivity
import com.untec.therealstart.investor2ir.data.db.example.ExampleDao
import javax.inject.Inject

class InvestorActivity : BaseActivity() {
    @Inject
    lateinit var exampleDao: ExampleDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investor)

        //Example code for working with ROOM
        val example = Example(0, "Sardor", "Islomov")
        Single.fromCallable({
            exampleDao?.insert(example)
        }).subscribeOn(Schedulers.io()).subscribe({
            exampleDao?.getAll()?.subscribe({
                Log.d("room_test","READ SUCCESS: " + it.toString())
            },{
                Log.d("room_test",it.message)
            })
        },{
            Log.d("room_test",it.message)

        })


        val exampleFragment = InvestorFragment()
        supportFragmentManager.beginTransaction().add(
                R.id.fragment, exampleFragment).commit()
    }
}
