package br.eti.urbano.mobile.contact.retrofit

import br.eti.urbano.mobile.contact.resource.ContactResource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BootstrapRetrofit{

    private val END_POINT = "urbano.eti.br:4567/api/contact"

    private val retrofit = Retrofit.Builder()
            .baseUrl(END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun customerResource() = retrofit.create(ContactResource::class.java)

}