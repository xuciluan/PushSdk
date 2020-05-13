package zwzt.fangqiu.edu.com.pushcore

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

    /**
     * 上传日志文件，前提是开启了 Debug模式，否则没有日志产生
     */
    fun uploadLogFile(context: Context)
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

//    /**
//     * 接受到透传消息
//     */
//    fun onReceivePassThroughMessage(context: Context, message: ZTPushMessage)
//
//    /**
//     * 收到推送token
//     */
//    fun onReceivedRegId(context: Context, regId:String)
//
//    /**
//     * 当消息被展示，当开发者需要在本地存储被展示过的通知内容时使用
//     * @param message 被展示的对象
//     */
//    fun  onNotificationShowedResult(context: Context, message:ZTPushMessage)
}