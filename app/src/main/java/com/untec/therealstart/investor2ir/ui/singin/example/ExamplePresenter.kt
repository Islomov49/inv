package com.untec.therealstart.investor2ir.ui.singin.example

import android.util.Log
import com.untec.therealstart.investor2ir.config.base.BasePresenterImpl
import com.untec.therealstart.investor2ir.data.DatabaseManager
import com.untec.therealstart.investor2ir.data.network.ApiDatabase
import com.untec.therealstart.investor2ir.utils.extensions.getHttpThrowable
import retrofit2.HttpException
import javax.inject.Inject

class ExamplePresenter @Inject constructor(view: ExampleContract.View?,val databaseManager: DatabaseManager,val apiDatabase: ApiDatabase) : BasePresenterImpl<ExampleContract.View>(view), ExampleContract.Presenter {

    override fun initData() {
        apiDatabase.getVerificationCode("islomov49@gmail.com").subscribe({
            Log.d("TEST_REST","SUCCESS")
        },{
            Log.d("TEST_REST",it.getHttpThrowable()?.code().toString() +" :  "  + it.getHttpThrowable()?.response()!!.errorBody())
        })
    }


}