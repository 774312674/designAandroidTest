package com.test.kotlntest

import java.io.PrintStream

/**
 * Created by admin on 2017/5/22.
 */

fun sumtesto(a:Int = 0,b:Int = 2) :Int{
   return a+b
}
fun sumtextt(a: Int,b: Int) = a+b

fun sumstring(a:Int , b: Int) = "和 = ${sumtextt(a,b)}"

fun maxInt(a: Int,b: Int) = if (a > b)a else b
 //字符串 插值
fun initdata():String {
   var name = "ccccc";
   return "dddd $name"
}



