package com.keep.datetimepick

//接收广播
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
class myBroadcastReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("com.tester.alarmmanager")) {
            //打开时间显示通知
            var b = intent.extras
            val notifyMe = Notifications()
            notifyMe.Notify(context!!,b.getString("message"),10)
        }else if(intent!!.action.equals("android.intent.action.BOOT_COMPLETED")){
            //完成时保存时间
            val saveData = SaveData(context!!)
            saveData.setAlarm()
        }
    }
}
