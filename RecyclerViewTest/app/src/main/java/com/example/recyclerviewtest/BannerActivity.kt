package com.example.recyclerviewtest

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.get
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.listener.OnBannerListener

class BannerActivity(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
                     //通过继承LinearLayout来构造控件
companion object{var clicked=false}
    init {
        LayoutInflater.from(context).inflate(R.layout.activity_banner, this)
                  //初始化，用LinearLayout的方式来构建控件
    }
    public fun bannerPicture(context: Context, num: Int, imageList2: ArrayList<Fruit>):Context {

        var r = 3000  //默认播放速度3秒一张
        if (num<=3){
            r=3000
        }else{
            r = 1000 * num
        }
        Toast.makeText(context, "速度:停留" +r/1000+"秒" , Toast.LENGTH_SHORT).show();
        var imageList: ArrayList<Uri> = ArrayList<Uri>()
        var count=1
        for (fruit in imageList2) {
            imageList.add(fruit.uri)
            count++
        }

        val banner = findViewById<Banner>(R.id.banner)
        //设置图片加载器
        val gil=GlideImageLoader(banner)
        banner.setImageLoader(gil)
        //设置图片集合
        banner.setImages(imageList)

//        if (clicked==false){
//            val onBannerListener1 = banner.setOnBannerListener(OnBannerListener() {
//                fun OnBannerClick(position: Int){
//                    banner.stopAutoPlay()
//                    Toast.makeText(context, "您点击了图片，播放停止", Toast.LENGTH_LONG).show();
//                    BannerActivity.clicked=true
//                }
//            })
//        }else{
//            val onBannerListener2 = banner.setOnBannerListener(OnBannerListener() {
//                fun OnBannerClick(position: Int){
//                    Toast.makeText(context, "进入图片详情显示界面", Toast.LENGTH_LONG).show();
//                    var intent = Intent(context, ShowSingleImage::class.java)
//                    intent.putExtra("message", "" + it)
//                    (context as Activity).startActivity(intent)
//                }
//            })
//        }

banner.setOnBannerListener {
    banner.stopAutoPlay()
                    Toast.makeText(context, "您点击了图片，播放停止", Toast.LENGTH_LONG).show();
    banner.setOnBannerListener {
        Toast.makeText(context, "进入图片详情显示界面", Toast.LENGTH_LONG).show();
                    var intent = Intent(context, ShowSingleImage::class.java)
                    intent.putExtra("message", "" + it)
                    (context as Activity).startActivity(intent)
    }
}


        //设置banner动画效果
        banner.setBannerAnimation(Transformer.BackgroundToForeground);
//        设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(r);

//        设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.DURATION);
        //banner设置方法全部调用完毕时最后调用
        banner.start()

return context
    }
}