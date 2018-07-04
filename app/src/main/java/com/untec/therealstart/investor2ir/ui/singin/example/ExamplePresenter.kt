package com.untec.therealstart.investor2ir.ui.singin.example

import com.untec.therealstart.investor2ir.config.base.BasePresenterImpl
import com.untec.therealstart.investor2ir.data.DatabaseManager
import javax.inject.Inject

class ExamplePresenter @Inject constructor(view: ExampleContract.View?,val databaseManager: DatabaseManager) : BasePresenterImpl<ExampleContract.View>(view), ExampleContract.Presenter {

    override fun initData() {
        view?.loadData()
        databaseManager.testLog()
    }


}