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