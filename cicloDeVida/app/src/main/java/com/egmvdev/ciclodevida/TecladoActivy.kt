package com.egmvdev.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egmvdev.ciclodevida.databinding.ActivityTecladoActivyBinding

class TecladoActivy : AppCompatActivity() {
    private lateinit var binding: ActivityTecladoActivyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTecladoActivyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_teclado_activy)

    }
}