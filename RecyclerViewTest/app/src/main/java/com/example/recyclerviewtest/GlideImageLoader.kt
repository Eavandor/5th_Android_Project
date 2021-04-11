package com.example.recyclerviewtest


import android.annotation.SuppressLint
import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.youth.banner.Banner
import com.youth.banner.loader.ImageLoader

class GlideImageLoader(val banner: Banner) : ImageLoader() {
    companion object{
        lateinit var biv:ImageView
    }

    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {

        if (context != null) {
            if (imageView != null) {
                Glide.with(context).load(path).into(imageView)





            }
        }

    }


}