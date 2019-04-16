package com.keep.notification

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {
    var notificationHelper: NotificationHelper?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notificationHelper = NotificationHelper(this)
    }
    //按钮1事件
    fun onClick1(view:View){
        notificationHelper!!.Notify(1,
            notificationHelper!!.getNotification1("First",editText.text.toString()))
    }
    //按钮2事件
    fun onClick2(view:View){
        notificationHelper!!.Notify(1,
            notificationHelper!!.getNotification1("Second",editText.text.toString()))
    }
    //按钮3事件
    fun onClick3(view:View){
        notificationHelper!!.Notify(1,
            notificationHelper!!.getNotification1("Third",editText.text.toString()))
    }
}
