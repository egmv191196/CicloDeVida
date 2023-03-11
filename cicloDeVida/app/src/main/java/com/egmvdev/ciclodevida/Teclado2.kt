package com.egmvdev.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.egmvdev.ciclodevida.databinding.ActivityTeclado2Binding

class Teclado2 : AppCompatActivity(), View.OnClickListener {
    var bandera = false
    var operacion = "vacio"
    var resultado: Double = 0.0
    private lateinit var binding: ActivityTeclado2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeclado2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.b0.setOnClickListener(this)
        binding.b1.setOnClickListener(this)
        binding.b2.setOnClickListener(this)
        binding.b3.setOnClickListener(this)
        binding.b4.setOnClickListener(this)
        binding.b5.setOnClickListener(this)
        binding.b6.setOnClickListener(this)
        binding.b7.setOnClickListener(this)
        binding.b8.setOnClickListener(this)
        binding.b9.setOnClickListener(this)

        binding.bclear.setOnClickListener(this)
        binding.bdiv.setOnClickListener(this)
        binding.bmul.setOnClickListener(this)
        binding.badd.setOnClickListener(this)
        binding.bminus.setOnClickListener(this)
        binding.benter.setOnClickListener(this)
        binding.bpunto.setOnClickListener(this)
        binding.bsupr.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.bclear->{
                binding.etnumero1.setText("")
                binding.etnumero2.setText("")
                binding.res.setText("")
                operacion = "vacio"
                bandera = false
            }
            R.id.bdiv->{
                bandera = true
                operacion = "div"
            }
            R.id.bmul->{
                bandera = true
                operacion = "mul"
            }
            R.id.badd->{
                bandera = true
                operacion = "add"
            }
            R.id.bminus->{
                bandera = true
                operacion = "minus"
            }
            R.id.benter->{
                if (bandera && binding.etnumero1.length()>0 && binding.etnumero2.length()>0){
                    when (operacion) {
                        "div" -> {
                            resultado = binding.etnumero1.text.toString().toDouble() / binding.etnumero2.text.toString().toDouble()
                        }
                        "mul" -> {
                            resultado = binding.etnumero1.text.toString().toDouble() * binding.etnumero2.text.toString().toDouble()
                        }
                        "add" -> {
                            resultado = binding.etnumero1.text.toString().toDouble() + binding.etnumero2.text.toString().toDouble()
                        }
                        "minus" -> {
                            resultado = binding.etnumero1.text.toString().toDouble() - binding.etnumero2.text.toString().toDouble()
                        }
                        else -> {
                            resultado = 0.0
                        }
                    }
                }
                bandera = false
                operacion = "vacio"
                binding.res.setText(resultado.toString())
            }
            R.id.bpunto->{
                if(!bandera) {
                    if (!binding.etnumero1.text.contains(".")){
                        binding.etnumero1.setText(binding.etnumero1.text.toString() + (p0 as Button).text.toString())
                    }
                }
                else {
                    if (!binding.etnumero2.text.contains(".")){
                        binding.etnumero2.setText(binding.etnumero2.text.toString() + (p0 as Button).text.toString())
                    }
                }
            }
            R.id.bsupr->{
                if(!bandera) binding.etnumero1.setText(binding.etnumero1.text.toString().dropLast(1))
                else binding.etnumero2.setText(binding.etnumero2.text.toString().dropLast(1))
            }
            R.id.b0, R.id.b1, R.id.b2, R.id.b3, R.id.b4, R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9->{
                if(!bandera) binding.etnumero1.setText(binding.etnumero1.text.toString() + (p0 as Button).text.toString())
                else binding.etnumero2.setText(binding.etnumero2.text.toString() + (p0   as Button).text.toString())
            }

        }
    }
}