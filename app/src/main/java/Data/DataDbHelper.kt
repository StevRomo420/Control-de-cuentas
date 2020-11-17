package Data


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class Clientes(val id:Int,val nombre:String,val telefono:Int,val saldo:Int,val direccion:String)

class DataDbHelper (context: Context): SQLiteOpenHelper(context,"Clientes.db",null,1){



    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL("CREATE TABLE Clientes(ID INTEGER PRIMARY KEY AUTOINCREMENT,Nombre TEXT NOT NULL,Telefono INTEGER,Saldo INTEGER,Direccion TEXT NOT NULL)")



    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS CLIENTES")
        onCreate(db)

    }

    fun insert(Nombre:String,Telefono:Int,Saldo:String,Direccion:String){

       val db =this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("Nombre",Nombre)
        contentValues.put("Telefono",Telefono)
        contentValues.put("Saldo",Saldo)
        contentValues.put("Direccion",Direccion)
        db.insert("Clientes",null,contentValues)



    }

    fun showCustomers():ArrayList<String>{
        var list : ArrayList<String> = arrayListOf()
        var db: SQLiteDatabase =readableDatabase
        var c = db.rawQuery("SELECT * FROM Clientes WHERE Saldo>0 ",null)

        while (c.moveToNext()){

            var nombre: String = c.getString(c.getColumnIndex("Nombre"))
            var telefono: String = c.getString(c.getColumnIndex("Telefono"))
            var saldo: String = c.getString(c.getColumnIndex("Saldo"))
            var direccion: String = c.getString(c.getColumnIndex("Direccion"))
            list.add(nombre)
           // list.add("Telefono: "+telefono)
           // list.add("Saldo: "+saldo)
           // list.add("Direccion: "+direccion)




        }
        return list

    }
    fun showAllCustomers():ArrayList<String>{
        var lista : ArrayList<String> = arrayListOf()
        var db: SQLiteDatabase =readableDatabase
        var s = db.rawQuery("SELECT * FROM Clientes",null)

        while (s.moveToNext()){

            var nombre: String = s.getString(s.getColumnIndex("Nombre"))
            var telefono: String = s.getString(s.getColumnIndex("Telefono"))
            var saldo: String = s.getString(s.getColumnIndex("Saldo"))
            var direccion: String = s.getString(s.getColumnIndex("Direccion"))
            lista.add(nombre)
            // list.add("Telefono: "+telefono)
            // list.add("Saldo: "+saldo)
            // list.add("Direccion: "+direccion)




        }
        return lista

    }

    fun selectionAll():List<Clientes>{
        var listaClientess: MutableList<Clientes> = ArrayList<Clientes>()
        val db = this.readableDatabase
        val c = db.rawQuery("SELECT * FROM Clientes",null)
        if (c.moveToFirst()){
            do {
                val all = Clientes(c.getInt(0),c.getString(1),c.getInt(2),
                    c.getInt(3),c.getString(4))
                listaClientess.add(all)



            }while (c.moveToNext())




        }
        return listaClientess
      }
    fun selection():List<Clientes>{
        var listaClientes: MutableList<Clientes> = ArrayList<Clientes>()
        val db = this.readableDatabase
        val c = db.rawQuery("SELECT * FROM Clientes",null)
        if (c.moveToFirst()){
            do {
                val all = Clientes(c.getInt(0),c.getString(1),c.getInt(2),
                    c.getInt(3),c.getString(4))
                listaClientes.add(all)



            }while (c.moveToNext())




        }
        return listaClientes
    }

     fun updateData(id:String,/*nombre:String,telefono:String,*/ saldo: Int/*,direccion:String*/):Boolean{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("ID",id)
       // contentValues.put("Nombre",nombre)
        //contentValues.put("Telefono",telefono)
        contentValues.put("Saldo",saldo)
        //contentValues.put("Direccion",direccion)
        db.update("Clientes",contentValues,"ID = ?", arrayOf(id))

         return true

      }








}