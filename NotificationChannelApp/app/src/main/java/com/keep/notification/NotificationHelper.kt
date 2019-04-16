package com.keep.notification
import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.os.Build

@TargetApi(Build.VERSION_CODES.O)
class NotificationHelper(context: Context):ContextWrapper(context){
    //管理通知
    val manager: NotificationManager by lazy {
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
    //初始化
    init {
        //通知1
        val cha1 = NotificationChannel(FIRST_CHANNEL,"First Channel",NotificationManager.IMPORTANCE_DEFAULT)
        //颜色
        cha1.lightColor = Color.GREEN
        //锁屏可见
        cha1.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        //创建通知
        manager.createNotificationChannel(cha1)


        //通知2
        val cha2 = NotificationChannel(SECOND_CHANNEL,"Second Channel",NotificationManager.IMPORTANCE_DEFAULT)
        //颜色
        cha2.lightColor = Color.GREEN
        //锁屏可见
        cha2.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        //创建通知
        manager.createNotificationChannel(cha2)


        //通知3
        val cha3 = NotificationChannel(THIRD_CHANNEL,"Third Channel",NotificationManager.IMPORTANCE_DEFAULT)
        //颜色
        cha3.lightColor = Color.GREEN
        //锁屏可见
        cha3.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        //创建通知
        manager.createNotificationChannel(cha3)
    }
    //获取通知1
    fun getNotification1(title:String,body:String):Notification.Builder{
        return Notification.Builder(applicationContext, FIRST_CHANNEL)
            .setContentText(body)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.abc_btn_colored_material)
            .setAutoCancel(true)
    }
    //获取通知2
    fun getNotification2(title:String,body: String):Notification.Builder{
        return Notification.Builder(applicationContext, SECOND_CHANNEL)
            .setContentText(body)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.abc_ab_share_pack_mtrl_alpha)
            .setAutoCancel(true)
    }
    //获取通知3
    fun getNotification3(title: String,body: String): Notification.Builder{
        return Notification.Builder(applicationContext, THIRD_CHANNEL)
            .setContentText(body)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.abc_btn_check_to_on_mtrl_000)
            .setAutoCancel(true)
    }

    fun Notify(i: Int, notification: Notification.Builder) {
        manager.notify(i,notification.build())
    }

    companion object{
        val FIRST_CHANNEL = "first"
        val SECOND_CHANNEL = "second"
        val THIRD_CHANNEL = "third"
    }
}
