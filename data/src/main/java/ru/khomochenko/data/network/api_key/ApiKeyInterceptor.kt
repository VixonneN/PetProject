package ru.khomochenko.data.network.api_key

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url
        val newUrl = url.newBuilder()
            .addQueryParameter("client_id", API_KEY)
            .build()
        val authRequest = request.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(authRequest)
    }

    private companion object {
        const val API_KEY = "TqO0GPEru1odG3dSGSOIz1aghOfwJCqrurvhJB9sU0I"
    }
}