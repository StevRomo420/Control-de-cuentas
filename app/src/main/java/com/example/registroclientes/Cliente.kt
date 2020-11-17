package com.example.registroclientes

import android.widget.Toast
import java.nio.file.attribute.FileOwnerAttributeView

 class Cliente {

     private var id:Int = 0
     private  var name: String = ""
     private var phone:Int = 0
     private var balance: Int? = 0
     private var direction: String = ""

     constructor(id:Int,name: String, phone:Int,balance:Int,direction:String){
         this.id = id
         this.name = name
         this.phone = phone
         this.balance = balance
         this.direction = direction

     }




     fun getId():Int{
         return id
     }

     fun getName():String{
         return name
     }
     fun getPhone():Int{
         return phone
     }

     fun getBalance(): Int? {
         return balance
     }
     fun getDirection():String{
         return direction
     }

     override fun toString(): String {
         return "$name\n$phone\n$direction"
     }


 }