package com.egmvdev.ciclodevida.clases

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.egmvdev.ciclodevida.databinding.ListalibrosBinding
import com.egmvdev.ciclodevida.model.Libro

class ListaLibroAdaptador (contexto: Context, var items: List<Libro> = arrayListOf()): ArrayAdapter<Libro>(contexto, 0, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ListalibrosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.txtTitulo.text = items[position].Titulo
        binding.txtAutor.text = items[position].Autor
        binding.txtPrecio.text = "$"+items[position].Precio.toString()
        binding.imgView.setImageDrawable(context.getDrawable(items[position].imagenId))
        return binding.root
    }
}