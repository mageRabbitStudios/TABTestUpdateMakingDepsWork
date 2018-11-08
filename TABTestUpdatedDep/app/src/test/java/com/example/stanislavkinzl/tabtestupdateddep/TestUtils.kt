package com.example.stanislavkinzl.tabtestupdateddep

import com.google.gson.Gson
import java.util.*

inline fun <reified T> fileToGson(fileName: String): T {
    val jsonString = readFileAsString(T::class.java, fileName)
    return Gson().fromJson<T>(jsonString, T::class.java)
}

fun readFileAsString(clazz: Class<*>, fileName: String): String {
    val inputStream = clazz.classLoader.getResourceAsStream(fileName)
    val scanner = Scanner(inputStream).useDelimiter("\\A")
    return if (scanner.hasNext()) scanner.next() else ""
}

