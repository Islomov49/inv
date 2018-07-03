package com.untec.therealstart.investor2ir.config.base


abstract class BasePresenterImpl<V: BaseView>(protected var view: V?) : BasePresenter  {

}