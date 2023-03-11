package com.egmvdev.ciclodevida

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egmvdev.ciclodevida.databinding.ActivityReceptorBinding

class ReceptorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReceptorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceptorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val a = intent.getStringExtra(resources.getString(R.string.identificador))?:""
        binding.texv1.text = a
        binding.btnCerrar1.setOnClickListener {
            val intento = Intent()

            //intento.putExtra("TEXTO_IDENTIFICADOR", "RESPUESTA POR UN INTENT DEL RECEPTOR")
            intento.putExtra( resources.getString(R.string.identificador), "RESPUESTA POR UN INTENT DEL RECEPTOR1")
            setResult(Activity.RESULT_OK,intento)//Envia un ok al activity que esta es esperando su respuesta
            finish()
        }
    }
}