package com.egmvdev.ciclodevida

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.widget.Toast
import com.egmvdev.ciclodevida.clases1.AlumnoContract
import com.egmvdev.ciclodevida.databinding.ActivitySqliteBinding
import com.egmvdev.ciclodevida.model.Alumno

class SQLite : AppCompatActivity() {
    val listaAlumnos = mutableListOf<Alumno>()
    private lateinit var binding : ActivitySqliteBinding
    val DbHelper = AlumnoContract.AlumnoDbHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySqliteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Insertar.setOnClickListener {
            insert()
        }
        binding.Mostrar.setOnClickListener {
            leer()
        }
        binding.Editar.setOnClickListener {
            actualizar()
        }
        binding.Eliminar.setOnClickListener {
            borrar()
        }
    }

    fun insert(){
        val db = DbHelper.writableDatabase
        val alumno = Alumno(0,"Edgar","egmv01@gmail.com","201500758")
        val valores = ContentValues().apply {
            put(AlumnoContract.Alumno.NOMBRE, alumno.nombre)
            put(AlumnoContract.Alumno.CORREO, alumno.correo)
            put(AlumnoContract.Alumno.CODIGO, alumno.codigo)
        }
        val idAlumno = db.insert(AlumnoContract.Alumno.NOMBRE_TABLA, null,valores)
        Toast.makeText(this,"valor ingresado $idAlumno", Toast.LENGTH_LONG).show()
    }
    fun leer(){
        val db =DbHelper.readableDatabase
        val proyeccion = arrayOf(BaseColumns._ID,AlumnoContract.Alumno.NOMBRE,AlumnoContract.Alumno.CODIGO, AlumnoContract.Alumno.CORREO)
        val cursor = db.query(AlumnoContract.Alumno.NOMBRE_TABLA,proyeccion,null,null,null,null,null,null)
        with(cursor){
            while(moveToNext()){
                listaAlumnos.add(Alumno(getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                        getString(getColumnIndexOrThrow(AlumnoContract.Alumno.NOMBRE)),
                        getString(getColumnIndexOrThrow(AlumnoContract.Alumno.CODIGO)),
                        getString(getColumnIndexOrThrow(AlumnoContract.Alumno.CORREO))))
            }
        }
        for (alumno in listaAlumnos){
            Log.i("ALUMNO", alumno.nombre)
        }
    }
    fun actualizar(){
        val db = DbHelper.writableDatabase
        val valores = ContentValues().apply {
            put(AlumnoContract.Alumno.NOMBRE, "Juan")
        }
        val  seleccion = "${BaseColumns._ID} = ?"
        val selectArgs = arrayOf("1")
        val filasActulizadas = db.update(AlumnoContract.Alumno.NOMBRE_TABLA, valores,seleccion, selectArgs)
        Toast.makeText(this,"Filas Actu",Toast.LENGTH_LONG).show()
    }
    fun borrar(){
        val db= DbHelper.writableDatabase
        val seleccion ="${BaseColumns._ID} =?"
        val selectArgs = arrayOf("2")
        val filasBorradas = db.delete(AlumnoContract.Alumno.NOMBRE_TABLA,seleccion,selectArgs)
    }
}