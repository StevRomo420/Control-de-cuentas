package com.example.registroclientes

import Data.Clientes
import Data.DataDbHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_ventas.*
import kotlinx.android.synthetic.main.activity_ver_clientes.*

class Ventas : AppCompatActivity() {
    private val connexion = DataDbHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventas)

        var lista:ArrayList<String> = connexion.showAllCustomers()
        var clientes:List<Clientes> = connexion.selection()
        var adp : ArrayAdapter<String>
        adp = ArrayAdapter(this,android.R.layout.simple_list_item_1,lista)
        listaVentas.adapter = adp

        listaVentas.setOnItemClickListener { parent: AdapterView<*>?, view: View?, i: Int, id: Long ->

            val id = clientes[i].id
            val nombre = clientes[i].nombre
           // val telefono = clientes[i].telefono
            val saldo = clientes[i].saldo
           // val direccion = clientes[i].direccion

            val intent = Intent(this, Productos::class.java)

            intent.putExtra("ID", id)
            intent.putExtra("Nombre", nombre)
            //intent.putExtra("Telefono", telefono)
            intent.putExtra("Saldo", saldo)
           // intent.putExtra("Direccion", direccion)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.to_right)
        }




    }//Fin de onCreate




}//Fin de la clase