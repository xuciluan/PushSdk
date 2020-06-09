package com.zwzt.xingepush

import android.content.Context
import com.tencent.android.tpush.XGIOperateCallback
import com.tencent.android.tpush.XGPushConfig
import com.tencent.android.tpush.XGPushManager
import zwzt.fangqiu.edu.com.pushsdk.common.IPushManager
import zwzt.fangqiu.edu.com.pushsdk.common.PushMessageHandler
import zwzt.fangqiu.edu.com.pushsdk.common.RegisterCallback
import zwzt.fangqiu.edu.com.pushsdk.common.ZTPushConfig


object XingePushManager : IPushManager {

    var handler : PushMessageHandler? = null

    override fun initPush(context: Context, callback: RegisterCallback?) {
        XGPushConfig.enableOtherPush(context,true)
        XGPushManager.registerPush(context, object : XGIOperateCallback{
            override fun onSuccess(data: Any?, flag: Int) {
                callback?.onRegisterSuccess(data.toString())
            }
            override fun onFail(data: Any?, errCode: Int, msg: String?) {
                callback?.onRegisterFailed(msg)
            }
        })
    }

    override fun initPush(context: Context, config: ZTPushConfig, callback: RegisterCallback?) {
        if (config.enableOtherPush){
            XGPushConfig.enableOtherPush(context,true)
        }

        if (config.meizuId != null && config.meizuKey != null){
            XGPushConfig.setMzPushAppId(context,config.meizuId)
            XGPushConfig.setMzPushAppKey(context,config.meizuKey)
        }

        if (config.oppoKey != null && config.oppoSecret != null){
            XGPushConfig.setOppoPushAppId(context,config.oppoKey)
            XGPushConfig.setOppoPushAppKey(context,config.oppoSecret)
        }

        if (config.xiaoMiId != null && config.xiaomiKey != null){
            XGPushConfig.setMiPushAppId(context,config.xiaoMiId)
            XGPushConfig.setMiPushAppKey(context,config.xiaomiKey)
        }

        XGPushManager.registerPush(context, object : XGIOperateCallback{
            override fun onSuccess(data: Any?, flag: Int) {
                callback?.onRegisterSuccess(data.toString())
            }
            override fun onFail(data: Any?, errCode: Int, msg: String?) {
                callback?.onRegisterFailed(msg)
            }
        })
    }

    override fun enableDebug(context: Context, debugMode: Boolean) {
        XGPushConfig.enableDebug = debugMode
    }

    override fun registerListener(handler: PushMessageHandler) {
        this.handler = handler
    }
}