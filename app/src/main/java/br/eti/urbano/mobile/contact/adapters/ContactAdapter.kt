package br.eti.urbano.mobile.contact.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.eti.urbano.mobile.contact.R
import br.eti.urbano.mobile.contact.model.Contact
import kotlinx.android.synthetic.main.activity_contact.view.*
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(private val contacts : List<Contact>,
                     private val context: Context) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val customer = contacts[position]
        viewHolder?.let { it.bindView(customer) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindView(contact : Contact){

            val name = itemView.txtItemName
            val phones = itemView.txtItemPhone
            val address = itemView.txtItemAddress

            //parse to view item view
            name.text = contact.name
            phones.text = contact.phones
            address.text = contact.address

        }
    }


}
