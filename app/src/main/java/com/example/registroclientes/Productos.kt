package com.example.registroclientes

import Data.DataDbHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pay.textName
import kotlinx.android.synthetic.main.activity_productos.*

class Productos : AppCompatActivity() {

    private val connexion = DataDbHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        var b: Bundle = intent.extras!!

        val nombre = b.getString("Nombre")

        val saldo = b.getInt("Saldo").toString()



        textCliente.setText(nombre)

        deuda.setText("₡"+saldo)

        btnSell.setOnClickListener(){


            Toast.makeText(applicationContext,"Aca iran algunos productos",Toast.LENGTH_LONG).show()



        }




    }



}