package com.egmvdev.ciclodevida

import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.egmvdev.ciclodevida.clases.ListaAdaptador
import com.egmvdev.ciclodevida.databinding.ActivityListViewBinding
import com.egmvdev.ciclodevida.model.Auto

class ListViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var a1 = arrayListOf<Auto>(Auto("Volkswagen","Virtus", R.drawable.virtus),Auto("Toyota","Hybrid",R.drawable.hybrid), Auto("BMW","X1",R.drawable.x1),Auto("Mazda", "M6",R.drawable.m6), Auto("Tesla","S", R.drawable.s ))
        //var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, a1)
        var adapter = ListaAdaptador(this,a1)
        binding.LVMascotas.adapter = adapter
    }


}