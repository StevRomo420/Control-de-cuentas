package com.example.registroclientes

import Data.DataDbHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_agregar_cliente.*

class AgregarCliente : AppCompatActivity() {


    private var name = ""
    private var phone = ""
    private var direction = ""
    private var balance = 1


    private val connexion = DataDbHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)

        registryCustomer()




    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.to_right,R.anim.to_left)
    }




    fun registryCustomer(){

        btnAddCustomer.setOnClickListener(){



            name = customerName?.text.toString()
            balance = 0
            direction = customerDirection?.text.toString()
            phone = customerPhone?.text.toString()
            connexion.insert(name,phone.toInt(),balance.toString(),direction)

            customerName!!.setText("")
            customerPhone!!.setText("")
            customerDirection!!.setText("")

            Toast.makeText(applicationContext,"Se Guardo un Cliente",Toast.LENGTH_LONG).show()




        }



    }





}