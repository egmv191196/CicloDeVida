package com.egmvdev.ciclodevida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.egmvdev.ciclodevida.databinding.FragmentBlueBinding
import com.egmvdev.ciclodevida.databinding.FragmentRedBinding

class BlueFragment : Fragment() {
    private var _binding: FragmentBlueBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlueBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHolaBlueFragment.setOnClickListener{
            Toast.makeText(activity,"HOLA AZUL", Toast.LENGTH_LONG).show()
        }
    }
}