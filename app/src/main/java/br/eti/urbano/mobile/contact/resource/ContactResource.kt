package br.eti.urbano.mobile.contact.resource

import br.eti.urbano.mobile.contact.model.Contact
import retrofit2.Call
import retrofit2.http.*

interface ContactResource {

    @GET(".")
    fun get(): Call<List<Contact>>

    @POST(".")
    fun post(@Body contact: Contact): Call<Contact>

    @PUT(".")
    fun put(@Body contact: Contact) : Call<Contact>

    @DELETE("/{id}")
    fun delete(@Path("id") id : Integer)

}