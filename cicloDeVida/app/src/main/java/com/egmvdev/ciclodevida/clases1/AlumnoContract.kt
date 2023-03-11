package com.egmvdev.ciclodevida.clases1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

object AlumnoContract {
    //Alumno
    object Alumno : BaseColumns {
        const val NOMBRE_TABLA = "alumnos"
        const val NOMBRE = "nombre"
        const val CODIGO = "codigo"
        const val CORREO = "correo"
    }
    //Libro
    object Libro : BaseColumns {
        const val NOMBRE_TABLA = "libros"
        const val TITULO = "titulo"
        const val AUTOR = "autor"
        const val PRECIO = "precio"
        const val FOTO = "foto"
    }


    private const val QUERY_CREAR_TABLA_ALUMNO =
        "create table ${Alumno.NOMBRE_TABLA} (${BaseColumns._ID} " +
                "integer primary key, ${Alumno.NOMBRE} text," +
                "${Alumno.CODIGO} text, ${Alumno.CORREO} text)"

    private const val QUERY_CREAR_TABLA_LIBRO =
        "create table ${Libro.NOMBRE_TABLA} (${BaseColumns._ID} integer primary key," +
                "${Libro.TITULO} text,"+
                "${Libro.AUTOR} text,"+
                "${Libro.PRECIO} text,"+
                "${Libro.FOTO} text)"

    private  const val QUERY_BORRAR_TABLA_ALUMNO = "drop table if exists ${Alumno.NOMBRE_TABLA}"

    class AlumnoDbHelper (context: Context) :
        SQLiteOpenHelper(context,NOMBRE_BASE_DE_DATOS,null,VERSION_BASE_DE_DATOS){
            companion object{
                const val VERSION_BASE_DE_DATOS = 2
                const val NOMBRE_BASE_DE_DATOS = "android"
            }

        override fun onCreate(p0: SQLiteDatabase?) {
            p0?.execSQL(QUERY_CREAR_TABLA_ALUMNO)
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            //p0?.execSQL(QUERY_BORRAR_TABLA_ALUMNO)
            p0?.execSQL(QUERY_CREAR_TABLA_LIBRO)
        }
    }
}