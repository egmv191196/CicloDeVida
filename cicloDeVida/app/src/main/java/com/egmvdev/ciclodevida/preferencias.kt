package com.egmvdev.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.egmvdev.ciclodevida.databinding.ActivityPreferenciasBinding

class preferencias : AppCompatActivity() {
    private  lateinit var binding: ActivityPreferenciasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenciasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.setTitle("Preferencias")
        //Obtener el dato de las preferencias
        val pref = PreferenceManager.getDefaultSharedPreferences(this)?: return
        Toast.makeText(this,pref.getBoolean("miniaturas",true).toString(),Toast.LENGTH_LONG).show()
        val sharPref = getSharedPreferences("PrefenciasCompartidas", MODE_PRIVATE)
        with(sharPref.edit()){
            putString("Nombre","Edgar")
            apply()//diferemcia entre apply y commit

        }

        //Agregar el fragment al activity con un framlayout de fragments
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.Frmpreferencias, PreferenciasFragmento())
            .commit()
    }
}