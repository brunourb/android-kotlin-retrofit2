package br.eti.urbano.mobile.contact.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import br.eti.urbano.mobile.contact.R
import br.eti.urbano.mobile.contact.adapters.ContactAdapter
import br.eti.urbano.mobile.contact.model.Contact
import br.eti.urbano.mobile.contact.retrofit.BootstrapRetrofit
import kotlinx.android.synthetic.main.activity_customer.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        val call = BootstrapRetrofit().customerResource().get()
        call.enqueue(object : Callback<List<Contact>?> {
            override fun onResponse(call: Call<List<Contact>?>?,
                                    response: Response<List<Contact>?>?) {

                response?.body()?.let {
                    val contacts: List<Contact> = it
                    configureList(contacts)
                }
            }

            override fun onFailure(call: Call<List<Contact>?>, t: Throwable) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

    fun add(view : View){

        val name = txtName.text.toString()
        val phone = txtPhone.text.toString()
        val address = txtAddress.text.toString()

        val customer = Contact(name,phone,address)

        val call = BootstrapRetrofit().customerResource().post(customer)
        call.enqueue(object : Callback<Contact?> {
            override fun onFailure(call: Call<Contact?>, t: Throwable) {
                Log.e("onFailure error", t?.message)
            }

            override fun onResponse(call: Call<Contact?>, response: Response<Contact?>) {
                Toast.makeText(this@ContactActivity,response.code(),Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun configureList(contacts: List<Contact>) {
        val recyclerView = recyclerViewCustomer
        recyclerView.adapter = ContactAdapter(contacts, this)
        val layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}
