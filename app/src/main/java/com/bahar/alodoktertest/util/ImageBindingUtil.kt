package com.bahar.alodoktertest.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Bacharudin A.F on 08/08/19.
 */
object ImageBindingUtil {
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageDrawable(view: ImageView, drawable: Int) {
        Glide.with(view.context).load(drawable).into(view)
    }
}