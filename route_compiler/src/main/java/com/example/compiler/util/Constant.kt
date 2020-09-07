package com.example.compiler.util

/**
 * FileName: Constant
 * Author: rivenLee
 * Date: 2020/9/7 17:27
 */

object Constant {
    const val ACTIVITY = "android.app.Activity"
    const val ISERVICE = "com.xsm.easy.core.template.IService"
    const val ARGUMENTS_NAME = "moduleName"
    const val ANNOTATION_TYPE_ROUTE = "com.xsm.easy.annotation.Route"
    const val ANN_TYPE_EXTRA = "com.xsm.easy.annotation.Extra"
    const val ANNOTATION_TYPE_INTERCEPTOR = "com.xsm.easy.annotation.Interceptor"
    const val IROUTE_GROUP = "com.xsm.easy.core.template.IRouteGroup"
    const val IROUTE_ROOT = "com.xsm.easy.core.template.IRouteRoot"
    const val IEXTRA = "com.xsm.easy.core.template.IExtra"
    const val IINTERCEPTOR = "com.xsm.easy.core.template.IInterceptor"
    const val IINTERCEPTOR_GROUP = "com.xsm.easy.core.template.IInterceptorGroup"
    const val SEPARATOR = "_"
    const val PROJECT = "EaseRouter"
    const val NAME_OF_GROUP = PROJECT + SEPARATOR + "Group" + SEPARATOR
    const val NAME_OF_ROOT = PROJECT + SEPARATOR + "Root" + SEPARATOR
    const val PACKAGE_OF_GENERATE_FILE = "com.xsm.easyrouter.routes"
    const val METHOD_LOAD_INTO = "loadInto"
    const val METHOD_LOAD_EXTRA = "loadExtra"
    const val PARCELABLE = "android.os.Parcelable"
    private const val LANG = "java.lang"
    const val BYTE = LANG + ".Byte"
    const val SHORT = LANG + ".Short"
    const val INTEGER = LANG + ".Integer"
    const val LONG = LANG + ".Long"
    const val FLOAT = LANG + ".Float"
    const val DOUBEL = LANG + ".Double"
    const val BOOLEAN = LANG + ".Boolean"
    const val STRING = LANG + ".String"
    const val ARRAY = "ARRAY"
    const val ARRAYLIST = "java.util.ArrayList"
    const val LIST = "java.util.List"
    const val BYTEARRAY = "byte[]"
    const val SHORTARRAY = "short[]"
    const val BOOLEANARRAY = "boolean[]"
    const val CHARARRAY = "char[]"
    const val DOUBLEARRAY = "double[]"
    const val FLOATARRAY = "float[]"
    const val INTARRAY = "int[]"
    const val LONGARRAY = "long[]"
    const val STRINGARRAY = "java.lang.String[]"
    const val NAME_OF_EXTRA = SEPARATOR + "Extra"
    const val NAME_OF_INTERCEPTOR = PROJECT + SEPARATOR + "Interceptor" + SEPARATOR
}