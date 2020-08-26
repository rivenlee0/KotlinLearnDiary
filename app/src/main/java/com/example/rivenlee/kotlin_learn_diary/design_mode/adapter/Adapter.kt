package com.example.rivenlee.kotlin_learn_diary.design_mode.adapter

/**
 * 场景：国标（国内标准）插座为3个孔，德标准（德国标准）插座为2个孔
 * 问题：一国内游客去德国旅游，拿着国标的充电器（3个孔）如何使用德标的插孔（2个孔）
 * 解决办法：电源转化适配器
*/

/**
 * 国标接口
 */
interface GBSocketInterface {

    fun powerWithThreeFlat()
}

/**
 * 中国插座
 */
class GBSocket: GBSocketInterface {

    override fun powerWithThreeFlat() {
        println("使用三项扁头插孔供电")
    }
}

/**
 * 德标接口
 */
interface DBSocketInterface {

    fun powerWithTwoRound()
}

/**
 * 德国插座
 */
class DBSocket: DBSocketInterface {

    override fun powerWithTwoRound() {
        println("使用两项圆头插孔供电")
    }
}

/**
 * 德国宾馆
 */
class Hotel {
    //宾馆中有一个德标的插口
    private var dbSocket: DBSocketInterface? = null

    fun setDbSocket(dbSocket: DBSocketInterface) {
        this.dbSocket = dbSocket
    }
    //宾馆中有一个充电的功能
    fun charge() {
        dbSocket?.powerWithTwoRound()
    }
}

/**
 * 适配器实现德标接口
 */
class SocketAdapter: DBSocketInterface {
    //组合新接口
    private var gbSocket: GBSocketInterface
    //在创建适配器对象时，必须传入一个新接口的实现类
    internal constructor(gbSocket: GBSocketInterface) {
        this.gbSocket = gbSocket
    }
    //将对旧接口的调用适配到新接口
    override fun powerWithTwoRound() {
        gbSocket.powerWithThreeFlat()
    }

}

/**
 * 创建适配器，适配器需要将国标接口转换为德标接口，必须满足以下条件
 * 1 必须符合德国标准的接口，否则的话还是没办法插到德国插座中；
 * 2 在调用上面实现的德标接口进行充电时，提供一种机制，将这个调用转到对国标接口的调用 。
 *
 * 这就要求
 * 1 适配器必须实现原有的旧的接口
 * 2 适配器对象中持有对新接口的引用，当调用旧接口时，将这个调用委托给实现新接口的对象来处理，也就是在适配器对象中组合一个新接口。
 */
fun main(args: Array<String>) {
    //初始化一个中国插座对象， 用一个国标接口引用它
    val gbSocket = GBSocket()
    //创建一个旅馆对象
    val hotel = Hotel()
    //创建适配器,使国标接口适配国标接口
    val socketAdapter = SocketAdapter(gbSocket)
    //设置插座
    hotel.setDbSocket(socketAdapter)
    //在旅馆中给手机充电
    hotel.charge()

    //正常使用德标接口插座充电
    val dbSocket = DBSocket()
    hotel.setDbSocket(dbSocket)
    hotel.charge()
}