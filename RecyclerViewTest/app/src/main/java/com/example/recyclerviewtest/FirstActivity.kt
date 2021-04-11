package com.example.recyclerviewtest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    companion object {
        var fruitList = ArrayList<Fruit>()
       lateinit var cont:Context
        lateinit var numm:String

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        cont=this
        var num = intent.getStringExtra("message").toString()
        numm=num
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(FirstActivity.fruitList,this)
        recyclerView.adapter = adapter
        val choose = findViewById<Button>(R.id.fromalbum)
        val startrolling = findViewById<Button>(R.id.startrolling)
        choose.setOnClickListener {
            // 打开文件选择器
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            // 指定只显示照片
            intent.type = "image/*"
            startActivityForResult(intent, 2)
        }

        startrolling.setOnClickListener {

            AlertDialog.Builder(this).apply {
                setTitle("操作说明：")
                setMessage("左右滑动图片视为：滑动，不视为触碰（按照需求，触碰是停止），按照滑动处理，轮播根据用户手指滑动方向运动，而不是停在那；单击静止图片视为：单击图片，轮播停止在当前图片；单击运动中的图片" +
                        "视为挽留触碰的图片，由于轮播不能卡在两张图中间，故会就近滑向左邻右舍图片，而不能停在那，故，此行为视为“滑动（人为改变/挽留图片）”而非“静态触碰”")
                setCancelable(false)
                setPositiveButton("好") { dialog, which ->
                    var intent=Intent(cont,Slide::class.java)
                    intent.putExtra("message",num)
                    startActivity(intent)
                }
                setNegativeButton("返回") { dialog,
                                          which ->
                }
                show()

            }



        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
//            1 -> {
//                if (resultCode == Activity.RESULT_OK) {
//                    // 将拍摄的照片显示出来
//                    val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
////                    imageView.setImageBitmap(rotateIfRequired(bitmap))
////
//                }
//            }

            2 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    data.data?.let { uri ->
                        // 将选择的照片显示
                        fruitList.add(Fruit("",uri, cont))
                        Toast.makeText(cont ,"添加成功！",Toast.LENGTH_SHORT).show();
                        var intent=Intent(this,FirstActivity::class.java)
                        intent.putExtra("message",numm)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}