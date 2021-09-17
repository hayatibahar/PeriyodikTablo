package com.cloud.periyodiktablo.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

fun ImageView.getImage(url : String?){
    Picasso.get().load(url).resize(600,0).into(this)
}

@BindingAdapter("android:downloadImage")
fun downloadImage(view : ImageView, url : String?){
    view.getImage(url)
}