package com.untec.therealstart.investor2ir.ui.singin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.untec.therealstart.investor2ir.R
import com.untec.therealstart.investor2ir.config.base.BaseFragment

class InvestorFragment: BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment_example, container,
                false)
        return view
    }
}