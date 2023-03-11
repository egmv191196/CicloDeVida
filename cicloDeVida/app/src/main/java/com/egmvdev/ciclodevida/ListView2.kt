package com.egmvdev.ciclodevida

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.egmvdev.ciclodevida.databinding.ActivityListView2Binding

class ListView2 : AppCompatActivity() {
    private  lateinit var binding: ActivityListView2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var autos = arrayOf("Motocicleta", "Automovil", "Autobus", "Helicoptero", "Barco", "Tren", "Metro")
        binding = ActivityListView2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var adapter = ArrayAdapter(this, R.layout.simple_list_item_1, autos)
        binding.LVAutos.adapter = adapter
    }
}