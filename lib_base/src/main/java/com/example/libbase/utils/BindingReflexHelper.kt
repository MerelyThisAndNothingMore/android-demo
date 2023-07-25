package com.example.libbase.utils

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import java.lang.RuntimeException
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType
import java.util.*

/****
 * @author : zhangjin.rolling
 * @date : 星期二 2023/1/10
 */
object BindingReflexHelper {

    fun <VB : ViewBinding> getViewBinding(aClass: Class<*>, inflater: LayoutInflater?): VB {
        try {
            val actualTypeArguments =
                (Objects.requireNonNull(aClass.genericSuperclass) as ParameterizedType).actualTypeArguments
            for (i in actualTypeArguments.indices) {
                val tClass: Class<Any>
                try {
                    tClass = actualTypeArguments[i] as Class<Any>
                } catch (e: Exception) {
                    continue
                }
                if (ViewBinding::class.java.isAssignableFrom(tClass)) {
                    val inflateMethod = tClass.getMethod("inflate", LayoutInflater::class.java)
                    return inflateMethod.invoke(null, inflater) as VB
                }
            }
            return getViewBinding(aClass.superclass, inflater)
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        throw RuntimeException("ViewBinding initial fail")
    }
}