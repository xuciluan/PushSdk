package zwzt.fangqiu.edu.com.pushsdk

import android.content.Context

import com.zwzt.xingepush.XingePushManager
import zwzt.fangqiu.edu.com.pushsdk.common.IPushManager
import zwzt.fangqiu.edu.com.pushsdk.common.PushMessageHandler
import zwzt.fangqiu.edu.com.pushsdk.common.RegisterCallback
import zwzt.fangqiu.edu.com.pushsdk.common.ZTPushConfig

/**
 * 作文纸条默认推送管理者
 */
object ZTPushManager : IPushManager {

    private val proxy: IPushManager = XingePushManager
    /**
     * 默认初始化厂商通道
     */
    override fun initPush(context: Context, callback: RegisterCallback?) {
        proxy.initPush(context, callback)
    }

    override fun initPush(context: Context, config: ZTPushConfig, callback: RegisterCallback?) {
        proxy.initPush(context, config, callback)
    }

    override fun enableDebug(context: Context, debugMode: Boolean) {
        proxy.enableDebug(context, debugMode)
    }

    override fun registerListener(handler: PushMessageHandler) {
        proxy.registerListener(handler)
    }

}