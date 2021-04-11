package com.example.recyclerviewtest

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Slide : AppCompatActivity(), View.OnTouchListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)
        val lay=findViewById<LinearLayout>(R.id.ll_touch);
        try {
            var num = intent.getStringExtra("message").toInt()

            val ba=findViewById<com.example.recyclerviewtest.BannerActivity>(R.id.banact1)
         ba.bannerPicture(this, num,FirstActivity.fruitList)

        }catch (e:Exception){
            val ba=findViewById<com.example.recyclerviewtest.BannerActivity>(R.id.banact1)
            ba.bannerPicture(this,3,FirstActivity.fruitList)
            Toast.makeText(this ,"输入数据无效，系统按照默认速度（3秒一张）播放",Toast.LENGTH_LONG).show();
        }


    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        if (p1 != null) {
            when (p1.getAction()) {
                MotionEvent.ACTION_DOWN -> Toast.makeText(this ,"起始位置：(" + p1.getX().toString() + "," + p1.getY(),Toast.LENGTH_LONG).show();


                MotionEvent.ACTION_MOVE ->Toast.makeText(this ,"实时位置：(" + p1.getX().toString() + "," + p1.getY(),Toast.LENGTH_LONG).show();
                MotionEvent.ACTION_UP ->Toast.makeText(this ,"结束位置：(" + p1.getX().toString() + "," + p1.getY(),Toast.LENGTH_LONG).show();
                else -> {
                    Toast.makeText(this ,"Fail",Toast.LENGTH_LONG).show();
                }
            }
        }
        /**
         *  注意返回值
         *  true：view继续响应Touch操作；
         *  false：view不再响应Touch操作，故此处若为false，只能显示起始位置，不能显示实时位置和结束位置
         */
        /**
         * 注意返回值
         * true：view继续响应Touch操作；
         * false：view不再响应Touch操作，故此处若为false，只能显示起始位置，不能显示实时位置和结束位置
         */
        return true
    }
}