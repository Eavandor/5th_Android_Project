package com.example.recyclerviewtest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity
class Choosing_speed_activity(context:Context,attrs:AttributeSet) : LinearLayout(context,attrs) {
//这是一个控件，用来选择轮播图播放速度
    init {

    LayoutInflater.from(context).inflate(R.layout.speed_choice,this)

    findViewById<Button>(R.id.spd0_5).setOnClickListener {

        var intent=Intent(context,FirstActivity::class.java)
        intent.putExtra("message","7")
        (context as Activity).startActivity(intent)
       }
    findViewById<Button>(R.id.spd0_75).setOnClickListener {
        var intent=Intent(context,FirstActivity::class.java)
        intent.putExtra("message","6")
        (context as Activity).startActivity(intent)
    }

    findViewById<Button>(R.id.spd1).setOnClickListener {
        var intent=Intent(context,FirstActivity::class.java)
        intent.putExtra("message","5")
        (context as Activity).startActivity(intent)
    }
    findViewById<Button>(R.id.spd1_5).setOnClickListener {
        var intent=Intent(context,FirstActivity::class.java)
        intent.putExtra("message","4")
        (context as Activity).startActivity(intent) }
    findViewById<Button>(R.id.spd2).setOnClickListener {
        var intent=Intent(context,FirstActivity::class.java)
        intent.putExtra("message","3")
        (context as Activity).startActivity(intent)
    }
    findViewById<Button>(R.id.subm).setOnClickListener {
        var intent=Intent(context,FirstActivity::class.java)
        intent.putExtra("message",""+findViewById<EditText>(R.id.specofied_speed).text.toString())
        (context as Activity).startActivity(intent)
    }
}
}