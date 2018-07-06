package com.untec.therealstart.investor2ir.ui.singin.example

import android.util.Log
import com.untec.therealstart.investor2ir.config.base.BasePresenterImpl
import com.untec.therealstart.investor2ir.data.DatabaseManager
import com.untec.therealstart.investor2ir.data.network.ApiDatabase
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ExamplePresenter @Inject constructor(view: ExampleContract.View?,val databaseManager: DatabaseManager,val apiDatabase: ApiDatabase) : BasePresenterImpl<ExampleContract.View>(view), ExampleContract.Presenter {

    override fun initData() {
        view?.loadData()
        databaseManager.testLog()
        apiDatabase.getVerificationCode("isl551mov@gmail.com").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()
    }


}