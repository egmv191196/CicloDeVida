package com.egmvdev.ciclodevida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.egmvdev.ciclodevida.databinding.FragmentBlueBinding
import com.egmvdev.ciclodevida.databinding.FragmentGreeBinding

class GreeFragment : Fragment() {
    private var _binding: FragmentGreeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGreeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHolaGreenFragment.setOnClickListener{
            Toast.makeText(activity,"HOLA VERDE", Toast.LENGTH_LONG).show()
        }
    }
}