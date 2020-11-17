package com.example.registroclientes

import Data.DataDbHelper
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pay.*

class payActivity : AppCompatActivity() {

    private val connexion = DataDbHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        var b: Bundle = intent.extras!!
        val id = b.getInt("iD").toString()
        val nombre = b.getString("nombre")
        val telefono = b.getInt("telefono").toString()
        val saldo = b.getInt("saldo").toString()

        val direccion = b.getString("direccion")

        println("El id de el cliente es : "+id)

        textName.setText(nombre).toString()
        textPhone.setText(telefono).toString()
        textBalance.setText("₡"+saldo).toString()
        textDirection.setText(direccion).toString()

        btnPay.setOnClickListener{



            val dialog = AlertDialog.Builder(this)

            val dialogView = layoutInflater.inflate(R.layout.cuadro_2,null)
            val cancel = dialogView.findViewById<Button>(R.id.cancel)
            val acept = dialogView.findViewById<Button>(R.id.acept)
            val btnToPay = dialogView.findViewById<EditText>(R.id.btnToPay)

            dialog.setView(dialogView)
            var dialogPerso = dialog.create()
            dialogPerso.show()

            acept.setOnClickListener(){

                /*
                *
                * Se debe restringir el valor de la variable "abono"
                * ya que estas no puede llegar a ser > a saldo2,
                * puede llegar a ser == a saldo2 mas >
                *
                * */


                var z: Bundle = intent.extras!!


                val saldo2 = z.getInt("Saldo")

                val abono = btnToPay.text.toString().toInt()

                val total = saldo2-abono

                val actualiza = connexion.updateData(id,total)





                if (actualiza==true){
                    dialogPerso.dismiss()
                    textBalance.setText("₡$total")

                    Toast.makeText(applicationContext,"El cliente abono un total de: ₡"+"$abono"+"\nEl saldo actual es de: ₡"+"$total",Toast.LENGTH_LONG).show()


                }else{
                    Toast.makeText(applicationContext,"No se Actualizo el saldo revise",Toast.LENGTH_LONG)
                }


            }
            cancel.setOnClickListener(){

                dialogPerso.dismiss()


            }






        }




    }










}
