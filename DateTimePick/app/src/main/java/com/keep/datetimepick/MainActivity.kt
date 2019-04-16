package com.keep.datetimepick

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val saveData = SaveData(applicationContext)
        //设置时间
        textView.text = saveData.getHour().toString()+":"+saveData.getMinute().toString()
    }
    //打开时间
    fun onBuSetTime(view:View){
        val popTime = PopTime()
        val fm = fragmentManager
        popTime.show(fm,"select Time")
    }
    //设置时间
    fun SetTime(Hours: Int, Minute: Int){
        textView.text = Hours.toString()+":"+Minute.toString()
        val saveData = SaveData(applicationContext)
        saveData.SaveData(Hours,Minute)
        saveData.setAlarm()
    }
}
