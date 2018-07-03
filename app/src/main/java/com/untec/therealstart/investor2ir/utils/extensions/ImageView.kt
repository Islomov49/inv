package com.untec.therealstart.investor2ir.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.untec.therealstart.investor2ir.utils.GlideApp

internal fun ImageView.loadImage(url: String){
    GlideApp.with(this.context)
            .load(url)
            .centerCrop()
            .into(this)
}