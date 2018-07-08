package com.untec.therealstart.investor2ir.ui.singin.example

import com.untec.therealstart.investor2ir.config.base.BasePresenter
import com.untec.therealstart.investor2ir.config.base.BaseView

interface ExampleContract {

    interface Presenter : BasePresenter {
        fun initData()
    }

    interface View : BaseView {

    }
}