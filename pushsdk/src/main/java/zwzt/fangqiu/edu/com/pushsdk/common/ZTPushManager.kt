package zwzt.fangqiu.edu.com.pushsdk.common

import android.content.Context

interface IPushManager {

    fun initPush(context: Context,callback: RegisterCallback?)

    fun initPush(context: Context, config: ZTPushConfig, callback: RegisterCallback?)

    /**
     * 开启Debug模式
     * @param debugMode 默认为 false。如果要开启 Debug 日志，设为 true
     */
    fun enableDebug(context: Context, debugMode : Boolean)

    fun registerListener(handler: PushMessageHandler)
}

interface RegisterCallback {
    fun onRegisterSuccess(token : String)
    fun onRegisterFailed(msg:String?)
}

interface PushMessageHandler {

    /**
     * 通知点击回调 actionType=1为该消息被清除，actionType=0为该消息被点击
     */
    fun onNotificationClickResult(context: Context, message: ZTPushMessage?)
}