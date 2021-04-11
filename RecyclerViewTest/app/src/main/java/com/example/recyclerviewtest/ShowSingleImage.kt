package com.example.recyclerviewtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import java.lang.Integer.parseInt

class ShowSingleImage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_single_image)
        var str=intent.getStringExtra("message")
var position:Int=str.toInt()
        val img=findViewById<ImageView>(R.id.imageView2)

        Glide.with(this).load(FirstActivity.fruitList[position].uri).into(img)
        findViewById<Button>(R.id.button2).setOnClickListener {
            var intent= Intent(this,FirstActivity::class.java)
            intent.putExtra("message",""+FirstActivity.numm)
            startActivity(intent)
        }

    }
}