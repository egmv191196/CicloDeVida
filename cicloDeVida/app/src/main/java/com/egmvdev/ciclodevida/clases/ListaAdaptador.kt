package com.egmvdev.ciclodevida.clases

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.egmvdev.ciclodevida.databinding.ListaBinding
import com.egmvdev.ciclodevida.model.Auto

class ListaAdaptador (contexto: Context,var items: List<Auto> = arrayListOf()): ArrayAdapter<Auto>(contexto, 0, items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.txtItem1.text = items[position].Nombre
        binding.txtItem2.text = items[position].Model
        binding.imgView.setImageDrawable(context.getDrawable(items[position].imagenId))
        return binding.root

    }

    override fun getCount(): Int {
        return items.size
    }
}