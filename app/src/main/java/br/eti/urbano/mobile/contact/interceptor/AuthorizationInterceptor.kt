package br.eti.urbano.mobile.contact.interceptor

import android.util.Log
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    val TOKEN = "Bearer b9QLldmqZSVSsLfbubqR35SaTTzN8QVD";
    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        // Request customization: add request headers
        var headers = request.headers().newBuilder()
                .add("Authorization", TOKEN).build()
//        val request = requestBuilder.build()
        request = request.newBuilder().headers(headers).build();

        val response = chain.proceed(request)

        Log.e("request",request.url().toString());
        Log.e("header",request.header("Authorization"));

        return response
    }
}