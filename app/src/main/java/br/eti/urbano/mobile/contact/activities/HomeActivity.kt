package br.eti.urbano.mobile.contact.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.eti.urbano.mobile.contact.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun show(view: View) {
        when (view.id) {
            R.id.btnShowUser -> {
                val intent = Intent(this, ContactActivity::class.java)
                startActivity(intent)
            }
            else -> Toast.makeText(this,
                    "Erro ao selecionar opção",
                    Toast.LENGTH_SHORT).show()
        }
    }
}
