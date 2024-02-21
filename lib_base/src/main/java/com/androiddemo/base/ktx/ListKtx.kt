package com.androiddemo.base.ktx

/****
 * @author : zhangjing
 * @date : 星期三 9/27/23
 */


fun <E> List<E>.toArrayList(): ArrayList<E> {
    val arrayList = arrayListOf<E>()
    arrayList.addAll(this)
    return arrayList
}

inline fun <E> List<E>.doIfNotEmpty(block: (List<E>) -> Unit) {
    if (isNotEmpty()) {
        block(this)
    }
}

fun <E> List<E>.safeGet(index: Int): E? {
    return if (index in indices) {
        get(index)
    } else {
        null
    }
}