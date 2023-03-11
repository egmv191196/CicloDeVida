package com.egmvdev.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val TAG = "MAINACTIVITY-CICLOS"
    private lateinit var etnumero1: EditText
    private lateinit var etnumero2: EditText
    private lateinit var res: EditText
    var bandera = false
    var operacion = "vacio"
    var resultado: Double = 0.0
    lateinit var btn0: Button
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btnclear: Button
    lateinit var btndiv: Button
    lateinit var btnmul: Button
    lateinit var btnsup: Button
    lateinit var btnminus: Button
    lateinit var btnadd: Button
    lateinit var btnpunto: Button
    lateinit var btnenter: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraintlayout)
        Log.i(TAG, "onCreate")
        etnumero1 = EditText(this)
        etnumero1 = findViewById(R.id.etnumero1)
        etnumero2 = EditText(this)
        etnumero2 = findViewById(R.id.etnumero2)
        res = EditText(this)
        res = findViewById(R.id.res)

        btnclear = Button(this)
        btnclear = findViewById(R.id.bclear)
        btnclear.setOnClickListener{
            etnumero1.setText("")
            etnumero2.setText("")
            res.setText("")
            operacion = "vacio"
            bandera = false
        }

        btndiv = Button(this)
        btndiv = findViewById(R.id.bdiv)
        btndiv.setOnClickListener{
            bandera = true
            operacion = "div"
        }
        btnmul = Button(this)
        btnmul = findViewById(R.id.bmul)
        btnmul.setOnClickListener{
            bandera = true
            operacion = "mul"
        }

        btnadd = Button(this)
        btnadd = findViewById(R.id.badd)
        btnadd.setOnClickListener{
            bandera = true
            operacion = "add"
        }
        btnminus = Button(this)
        btnminus = findViewById(R.id.bminus)
        btnminus.setOnClickListener{
            bandera = true
            operacion = "minus"
        }
        btnenter = Button(this)
        btnenter = findViewById(R.id.benter)
        btnenter.setOnClickListener{
            if (bandera && etnumero1.length()>0 && etnumero2.length()>0){
                when (operacion) {
                    "div" -> {
                        resultado = etnumero1.text.toString().toDouble() / etnumero2.text.toString().toDouble()
                    }
                    "mul" -> {
                        resultado = etnumero1.text.toString().toDouble() * etnumero2.text.toString().toDouble()
                    }
                    "add" -> {
                        resultado = etnumero1.text.toString().toDouble() + etnumero2.text.toString().toDouble()
                    }
                    "minus" -> {
                        resultado = etnumero1.text.toString().toDouble() - etnumero2.text.toString().toDouble()
                    }
                    else -> {
                        resultado = 0.0
                    }
                }
            }
            bandera = false
            operacion = "vacio"
            res.setText(resultado.toString())
        }

        btnpunto = Button(this)
        btnpunto = findViewById(R.id.bpunto)
        btnpunto.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }

        btn0 = Button(this)
        btn0 = findViewById(R.id.b0)
        btn0.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }
        btn1 = Button(this)
        btn1 = findViewById(R.id.b1)
        btn1.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }
        btn2 = Button(this)
        btn2 = findViewById(R.id.b2)
        btn2.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }
        btn3 = Button(this)
        btn3 = findViewById(R.id.b3)
        btn3.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }
        btn4 = Button(this)
        btn4 = findViewById(R.id.b4)
        btn4.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }
        btn5 = Button(this)
        btn5 = findViewById(R.id.b5)
        btn5.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }
        btn6 = Button(this)
        btn6 = findViewById(R.id.b6)
        btn6.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }
        btn7 = Button(this)
        btn7 = findViewById(R.id.b7)
        btn7.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }
        btn8 = Button(this)
        btn8 = findViewById(R.id.b8)
        btn8.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }
        btn9 = Button(this)
        btn9 = findViewById(R.id.b9)
        btn9.setOnClickListener{
            if(!bandera) etnumero1.setText(etnumero1.text.toString() + (it as Button).text.toString())
            else etnumero2.setText(etnumero2.text.toString() + (it as Button).text.toString())
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }
}