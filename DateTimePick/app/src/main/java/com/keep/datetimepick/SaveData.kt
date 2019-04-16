package com.keep.datetimepick
//定时任务
import android.app.AlarmManager
import android.app.PendingIntent //异步激发调起任务
import android.content.Context //上下文
import android.content.Intent //消息传递对象
import android.content.SharedPreferences //存储数据类
import java.util.*
class SaveData{
    var context:Context?=null
    var sharedRef: SharedPreferences?=null
    constructor(context: Context){
        this.context = context //上下文对象
        sharedRef = context.getSharedPreferences("myref",Context.MODE_PRIVATE) //获取存储对象
    }
    //存储数据
    fun SaveData(hour:Int,minute:Int){
        var editor = sharedRef!!.edit()
        editor.putInt("hour",hour)
        editor.putInt("minute",minute)
        editor.commit()
    }
    //获取小时
    fun getHour():Int{
        return sharedRef!!.getInt("hour",0)
    }
    //获取分
    fun getMinute(): Int{
        return sharedRef!!.getInt("minute",0)
    }
    //设置闹钟
    fun setAlarm(){
        val hour:Int = getHour()
        val minute:Int = getMinute()
        val calender = Calendar.getInstance()//历法实例
        calender.set(Calendar.HOUR_OF_DAY,hour) //设置小时天
        calender.set(Calendar.MINUTE,minute)//设置分
        calender.set(Calendar.SECOND,0)//设置秒
        //系统定时任务报警
        val am = context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //消息
        var intent = Intent(context,myBroadcastReceiver::class.java)
        intent.putExtra("message","到时间了")
        intent.action = "com.tester.alarmmanager" //发出通知动作
        val pi = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT) //激发任务
        //重复设置
        am.setRepeating(AlarmManager.RTC_WAKEUP,calender.timeInMillis,AlarmManager.INTERVAL_DAY,pi)
    }
}
