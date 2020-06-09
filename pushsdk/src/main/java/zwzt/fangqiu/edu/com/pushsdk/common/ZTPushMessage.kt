package zwzt.fangqiu.edu.com.pushsdk.common

import androidx.fragment.app.FragmentActivity

/**
 * 接收到的推送消息
 */
data class ZTPushMessage(
    //消息 ID
    val messageId:Long,
    //通知标题
    val title : String,
    //通知正文内容
    val content:String,
    //被打开 activity名称
    val activityName:String,
    //被打开 activity 上下文
    val activity: FragmentActivity?,
    //actionType=1为该消息被清除，actionType=0为该消息被点击
    val actionType:Long,
    //自定义内容
    val customContent : String)