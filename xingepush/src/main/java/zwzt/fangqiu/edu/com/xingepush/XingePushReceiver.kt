package com.zwzt.xingepush

import android.content.Context
import com.tencent.android.tpush.*
import zwzt.fangqiu.edu.com.pushcore.ZTPushMessage

open class XingePushReceiver  : XGPushBaseReceiver() {

    override fun onDeleteAccountResult(p0: Context?, p1: Int, p2: String?) {

    }

    override fun onSetTagResult(p0: Context?, p1: Int, p2: String?) {

    }

    override fun onUnregisterResult(p0: Context?, p1: Int) {
    }

    override fun onDeleteTagResult(p0: Context?, p1: Int, p2: String?) {

    }

    override fun onRegisterResult(p0: Context?, p1: Int, p2: XGPushRegisterResult?) {

    }

    override fun onTextMessage(p0: Context?, p1: XGPushTextMessage?) {

    }

    override fun onNotificationClickedResult(context: Context?, result: XGPushClickedResult?) {

        if (result != null){
           val message = ZTPushMessage(result.msgId,
               result.title,
               result.content,
               result.activityName,
               null,
               result.actionType,
               result.customContent)
            XingePushManager.handler?.onNotificationClickResult(context!!,message)
       } else {
            XingePushManager.handler?.onNotificationClickResult(context!!,null)
       }
    }

    override fun onSetAccountResult(p0: Context?, p1: Int, p2: String?) {
    }

    override fun onNotificationShowedResult(p0: Context?, p1: XGPushShowedResult?) {

    }

}