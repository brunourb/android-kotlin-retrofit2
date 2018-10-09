package br.eti.urbano.mobile.contact.retrofit

import br.eti.urbano.mobile.contact.interceptor.AuthorizationInterceptor
import br.eti.urbano.mobile.contact.resource.ContactResource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BootstrapRetrofit{

    private val END_POINT = "http://somedomain/context/resource" //http://somedomain/context/resource

    fun retrofit() : Retrofit {

        val interceptor = HttpLoggingInterceptor()
        val authorization = AuthorizationInterceptor();
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(authorization)

        val client = OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(authorization).build()

        //PASSO 1
        return Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
    }

    fun customerResource() = retrofit().create(ContactResource::class.java)

}