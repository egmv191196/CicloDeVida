package com.egmvdev.ciclodevida

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.egmvdev.ciclodevida.databinding.ActivityComunicacionesBinding

class ComunicacionesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComunicacionesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComunicacionesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.abrirReceptor1.setOnClickListener {
            var intent: Intent = Intent(this, ReceptorActivity::class.java)
            intent.putExtra(resources.getString(R.string.identificador),"RECEPTOR 0 DESDE COMUNICACION")
            //startActivity(intent)
            resultadoLanzador.launch(intent)
        }
        binding.abrirReceptor2.setOnClickListener {
            var intent: Intent = Intent(this, ReceptorActivity2::class.java)
            startActivity(intent)
        }
        binding.abrirReceptor3.setOnClickListener {
            var intent: Intent = Intent(this, ReceptorActivity3::class.java)
            startActivity(intent)
        }

    }
    //Se lanza la actividad desde este lanzador pero espera una respuesta al cerrar el boton del acitivity receptor
    var resultadoLanzador =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            resultado ->
            if (resultado.resultCode == Activity.RESULT_OK){
                val mens = resultado.data?.getStringExtra(resources.getString(R.string.identificador))?:"Vacio"//Obtiene el mensaje del activity que fue llamado
                //val mens = resultado.data?.getStringExtra("TEXTO_IDENTIFICADOR")?:"Vacio"//Obtiene el mensaje del activity que fue llamado

                Toast.makeText(this, mens, Toast.LENGTH_SHORT).show()
            }
        }
}