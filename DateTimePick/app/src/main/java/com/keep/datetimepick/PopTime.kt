package com.keep.datetimepick
//时间dialog片段
import android.app.DialogFragment
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
class PopTime:DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var myView = inflater!!.inflate(R.layout.pop_time,container,false)//拓展试图层次
        var btnDone = myView.findViewById(R.id.btnDone) as Button
        var tp1 = myView.findViewById(R.id.pop_time) as TimePicker
        btnDone.setOnClickListener({
            val ma = activity as MainActivity
            //sdk 版本大于23就设置时间。否则设置当前时间
            if(Build.VERSION.SDK_INT >= 23){
                ma.SetTime(tp1.hour,tp1.minute)
            }else{
                ma.SetTime(tp1.currentHour,tp1.currentMinute)
            }
            this.dismiss()
        })
        return myView
    }
}