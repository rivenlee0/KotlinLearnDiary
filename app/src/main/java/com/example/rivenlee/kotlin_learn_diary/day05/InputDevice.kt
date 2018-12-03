package com.example.rivenlee.kotlin_learn_diary.day05

/**
 * author: rivenlee
 * date: 2018/12/3
 * email: rivenlee0@gmail.com
 */
interface InputDevice {
    fun input(event: Any)
}

interface USBInputDevice: InputDevice

interface BLEInputDevice: InputDevice

class USBMouse(val name: String): USBInputDevice{
    override fun input(event: Any) {

    }

    override fun toString(): String {
        return name
    }

}

class Computer{

    fun addUSBInputDevice(inputDevice: USBInputDevice){
        println("add USB input device: $inputDevice")
    }
    fun addBLEInputDevice(inputDevice: BLEInputDevice){
        println("add USB input device: $inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice){
        when (inputDevice) {
            is USBInputDevice -> {
                addUSBInputDevice(inputDevice)
            }
            is BLEInputDevice -> {
                addBLEInputDevice(inputDevice)
            }
            else -> {
                throw IllegalArgumentException("输入设备类型不支持")
            }
        }
    }
}

fun main(args: Array<String>) {
    val computer = Computer()
    val inputDevice = USBMouse("罗技鼠标")
    computer.addInputDevice(inputDevice)
}