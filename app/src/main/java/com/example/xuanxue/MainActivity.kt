package com.example.xuanxue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //保存抽奖名单
    var names = listOf<String>("孙铠林","牟鲜","王缤清")
    //定时器 每隔一段事件切换一次名字
    lateinit var timer: Timer
    //记录当前索引
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }
    private fun init(){
        // 设置默认显示第一个人
        mNameTextView.text = names[index]

        // 给按钮添加点击事件
        mStartButton.setOnClickListener{
            //判断标题是Start还是Stop
            if (mStartButton.text.toString() == "Start"){
                mStartButton.text ="Stop"
                // 创建定时器
                timer = Timer()
                // 分配定时任务
                timer.schedule(object : TimerTask() {
                    override fun run() {
                        //判断是否越界
                        index = if (index+1 > names.size-1) 0 else index+1
                        Log.v("pxd","$index")
                            //取出对应的名字
                            mNameTextView.text = names[index]
                            //改变索引值
                        }
                    },0,100)
            }else{
                mStartButton.text ="Start"
                timer.cancel()
            }
        }
    }
}