package zwzt.fangqiu.edu.com.pushsdk.common

data class ZTPushConfig(
    val oppoKey: String?,
    val oppoSecret: String?,
    //魅族
    val meizuId: String?,
    val meizuKey: String?,
    //小米
    val xiaoMiId: String?,
    val xiaomiKey: String?,
    //开启五大厂商通道
    val enableOtherPush: Boolean = true
)