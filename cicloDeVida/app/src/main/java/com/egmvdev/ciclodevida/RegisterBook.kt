package com.egmvdev.ciclodevida

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.egmvdev.ciclodevida.databinding.ActivityRegisterBookBinding

class RegisterBook : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bandera = intent.getBooleanExtra("Bandera",false)
        val titulo = intent.getStringExtra("Titulo")?:""
        val tituloA = titulo
        val autor = intent.getStringExtra("Autor")?:""
        val precio = intent.getStringExtra("Precio")?:""
        val position = intent.getStringExtra("Position")?:""
        if (bandera == true ){
            binding.ETitulo.setText(titulo)
            binding.EAutor.setText(autor)
            binding.EPrecio.setText(precio)
            binding.BtnAdd.setText("Guardar Cambios")
        }


        binding.BtnAdd.setOnClickListener {
            if(binding.EAutor.text.isNotEmpty() && binding.ETitulo.text.isNotEmpty() && binding.EPrecio.text.toString().isNotEmpty()){
                val intento = Intent()
                //intento.putExtra("TEXTO_IDENTIFICADOR", "RESPUESTA POR UN INTENT DEL RECEPTOR")
                intento.putExtra("TitleA", tituloA)
                intento.putExtra("Title", binding.ETitulo.text.toString())
                intento.putExtra("Autor", binding.EAutor.text.toString())
                intento.putExtra("Precio", binding.EPrecio.text.toString())
                intento.putExtra("Position", position)
                setResult(Activity.RESULT_OK,intento)//Envia un ok al activity que esta es esperando su respuesta
                finish()
                //Toast.makeText(this, binding.ETitulo.text.toString(), Toast.LENGTH_SHORT).show()
            }
            else{
                setResult(Activity.RESULT_CANCELED)//Envio un canceled
                finish()
            }

        }
    }
}