package br.eti.urbano.mobile.contact.resource

import br.eti.urbano.mobile.contact.model.Contact
import retrofit2.Call
import retrofit2.http.*

interface ContactResource {

    @GET("customer")
    fun get(): Call<List<Contact>>

    @POST("contact")
    fun post(@Body contact: Contact): Call<Contact>

    @PUT("customer/{id}")
    fun put(@Path("id") id : Integer)

    @DELETE("customer/{id}")
    fun delete(@Path("id") id : Integer)

}