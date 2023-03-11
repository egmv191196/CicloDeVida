package com.egmvdev.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egmvdev.ciclodevida.databinding.ActivityDetailBookBinding

class DetailBook : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var i = intent
        var title = i.getStringExtra("Title")
        var autor = i.getStringExtra("Autor")
        var precio1 = i.getDoubleExtra("Precio",0.0)
        var img = i.getIntExtra("Img",0)

        binding.Txvtitle.text = title
        binding.TxvAutor.text = autor
        binding.TxvPrecio.text = "$$precio1"
        binding.imgFoto.setImageDrawable(getDrawable(img))

    }
}