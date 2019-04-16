package com.keep.datetimepick

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat
//通知类
class Notifications(){
    val NOTIFIYTAG = "new request"
    fun Notify(context:Context,message:String,number:Int){
        val  intent = Intent(context,MainActivity::class.java)

        val builder = NotificationCompat.Builder(context)
            .setDefaults(Notification.DEFAULT_ALL)
            .setContentTitle("新请求")
            .setContentText(message)
            .setSmallIcon(R.drawable.abc_btn_borderless_material)
            .setContentIntent(PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)) //展示到主视图上去
            .setAutoCancel(true)
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //判断sdk 版本来显示通知
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR){
            nm.notify(NOTIFIYTAG,0,builder.build())
        }else{
            nm.notify(NOTIFIYTAG.hashCode(),builder.build())
        }
    }
}