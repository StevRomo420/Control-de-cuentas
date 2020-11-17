package com.example.registroclientes

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // list.add(Cliente(0,name,balance=0, direction))

        addButton()
        addSales()
        payment()
        seeBalance()
        leave()





    }

    fun addButton(){

       addCustomer.setOnClickListener(){

           startActivity(Intent(applicationContext, AgregarCliente::class.java))
           overridePendingTransition(R.anim.fade_in,R.anim.to_right)


       }

    }
    fun addSales(){

        addSale.setOnClickListener(){

            startActivity(Intent(applicationContext, Ventas::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.to_right)




        }


    }


    fun payment(){

        addCash.setOnClickListener(){
            Toast.makeText(applicationContext,"Registrar Pagos",Toast.LENGTH_SHORT).show()
        }

    }

    fun seeBalance(){

        seeCustomerInformation.setOnClickListener(){
            startActivity(Intent(this,VerClientes::class.java))
            overridePendingTransition(R.anim.fade_in,R.anim.to_right)

        }


    }

    fun leave(){
        btnExt.setOnClickListener(){

            finishAffinity ()
        }


    }










}