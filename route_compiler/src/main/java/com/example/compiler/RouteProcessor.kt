package com.example.compiler

import com.example.annotation.Route
import com.example.compiler.util.Constant
import com.example.compiler.util.Log
import com.google.auto.service.AutoService
import javax.annotation.processing.*
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements
import javax.lang.model.util.Types


@AutoService(Processor::class)
class RouteProcessor : AbstractProcessor() {

    /**
     * 节点工具类 (类、函数、属性都是节点)
     */
    private var elementUtils: Elements? = null

    /**
     * type(类信息)工具类
     */
    private var typeUtils: Types? = null

    /**
     * 文件生成器 类/资源
     */
    private var filerUtils: Filer? = null

    private var log: Log? = null
    private var moduleName: String? = null

    @Synchronized
    override fun init(processingEnvironment: ProcessingEnvironment) {
        super.init(processingEnvironment)
        //获得apt的日志输出
        log = Log.newLog(processingEnvironment.messager)
        elementUtils = processingEnvironment.elementUtils
        typeUtils = processingEnvironment.typeUtils
        filerUtils = processingEnvironment.filer

        //参数是模块名 为了防止多模块/组件化开发的时候 生成相同的 xx$$ROOT$$文件
        val options = processingEnvironment.options
        if (options.isNotEmpty()) {
            moduleName = options[Constant.ARGUMENTS_NAME]
        }
        if (moduleName.isNullOrEmpty()) {
            throw RuntimeException("Not set processor moudleName option !")
        }
        log?.i("init RouterProcessor " + moduleName.toString() + " success !")
    }

    override fun process(set: MutableSet<out TypeElement>?, roundEnvironment: RoundEnvironment?): Boolean {
        if (!set.isNullOrEmpty()) {
            //被Route注解的节点集合
            val rootElements = roundEnvironment
                    ?.getElementsAnnotatedWith(Route::class.java)
            if (!rootElements.isNullOrEmpty()) {
                processorRoute(rootElements)
            }
            return true
        }
        return false
    }

    private fun processorRoute(rootElements: Set<Element>) {
        val activity = elementUtils?.getTypeElement(Constant.ACTIVITY)
        val service = elementUtils?.getTypeElement(Constant.ISERVICE)
        for (element in rootElements) {

        }

    }
}