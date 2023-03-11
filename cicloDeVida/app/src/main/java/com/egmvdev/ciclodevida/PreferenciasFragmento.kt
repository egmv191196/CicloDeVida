package com.egmvdev.ciclodevida

import android.os.Bundle
import android.widget.Toast
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference

class PreferenciasFragmento : PreferenceFragmentCompat() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var swMiniaturas = findPreference<SwitchPreference>("miniaturas")
        if (swMiniaturas != null){
            swMiniaturas.setOnPreferenceChangeListener { preference, newValue ->
                if (newValue == true){
                    Toast.makeText(requireActivity(),"hola",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(requireActivity(),"mundo",Toast.LENGTH_LONG).show()
                }
                    true
            }

        }
    }
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferencias, rootKey)

    }


}