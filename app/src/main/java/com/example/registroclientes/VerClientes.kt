package com.example.registroclientes

import Data.Clientes
import Data.DataDbHelper
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ver_clientes.*

class VerClientes : AppCompatActivity() {

    private val connexion = DataDbHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_clientes)

        var list:ArrayList<String> = connexion.showAllCustomers()
        var clientess:List<Clientes> = connexion.selectionAll()
        var adp :ArrayAdapter<String>
        adp = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        vista.adapter = adp


        vista.setOnItemClickListener{ parent: AdapterView<*>?, view: View?, i: Int, id: Long ->

            /*
            * Al apliacar el WHERE Saldo>0 se ebrreda ya que mostrara
            * una lista corta de clientes los cuales son los unicos que
            * que deben, pero al dar click lastimosamente toma el id del
            * array no el del cliente como tal asi que hay que encontar
            * la manera de restringir los datos
            *
            * */


            val id =clientess[i].id
            val nombre =clientess[i].nombre
            val telefono =clientess[i].telefono
            val saldo =clientess[i].saldo
            val direccion =clientess[i].direccion

            val intent = Intent(this, payActivity::class.java)

            intent.putExtra("iD",id)
            intent.putExtra("nombre",nombre)
            intent.putExtra("telefono",telefono)
            intent.putExtra("saldo",saldo)
            intent.putExtra("direccion",direccion)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in,R.anim.to_right)
            //finish()







        }


        }




    }




