package com.example.stanislavkinzl.tabtestupdateddep.app.database.remote

import com.example.stanislavkinzl.tabtestupdateddep.app.API_KEY
import com.example.stanislavkinzl.tabtestupdateddep.app.PRIVATE_KEY
import com.example.stanislavkinzl.tabtestupdateddep.app.extensions.md5
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalHttpUrl = chain.request().url()

        val currentTimestamp = getCurrentTimestamp()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("ts", currentTimestamp.toString())
            .addQueryParameter("hash", "$currentTimestamp$PRIVATE_KEY$API_KEY".md5())
            .build()
        return chain.proceed(chain.request().newBuilder().url(url).build())
    }

    private fun getCurrentTimestamp(): Long =
        Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000

}