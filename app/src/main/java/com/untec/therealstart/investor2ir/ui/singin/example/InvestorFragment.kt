package com.untec.therealstart.investor2ir.ui.singin.example

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.untec.therealstart.investor2ir.R
import com.untec.therealstart.investor2ir.config.base.BaseFragment
import javax.inject.Inject

class InvestorFragment: BaseFragment(), ExampleContract.View {


    override fun loadData() {
        Toast.makeText(context, "DEBUG", Toast.LENGTH_SHORT).show()
    }

    @Inject
    lateinit var presenter: ExampleContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment_example, container,
                false)
        presenter.initData()
        return view
    }
}