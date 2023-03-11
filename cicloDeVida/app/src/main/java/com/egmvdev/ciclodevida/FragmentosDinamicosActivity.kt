package com.egmvdev.ciclodevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.egmvdev.ciclodevida.databinding.ActivityFragmentosDinamicosBinding

class FragmentosDinamicosActivity : AppCompatActivity() {
    private var colores = arrayOf("SC", "SC", "SC", "SC")

    private lateinit var binding: ActivityFragmentosDinamicosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentosDinamicosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager?.beginTransaction()?.
        add(R.id.frmLay1,RedFragment(),"RED")?.
        add(R.id.frmLay3,PreferenciasFragmento(),"AZUL")
            ?.commit()
        colores[0] = "ROJO"
        colores[2] = "AZUL"



        binding.btnVerde.setOnClickListener{
            supportFragmentManager?.beginTransaction()?.
            add(R.id.frmLay2,GreeFragment(),"Verde")?.commit()
            colores[1] = "VERDE"
            binding.btnVerde.isEnabled = false

            /*
            var frgRojo = supportFragmentManager.findFragmentByTag("RED")
            var frgAzul = supportFragmentManager.findFragmentByTag("AZUL")
            if(!cambio){
                supportFragmentManager.beginTransaction()
                .replace(R.id.frmLay1, BlueFragment(), "BLUE")
                .replace(R.id.frmLay2, RedFragment(), "RED")
                .commit()
                cambio = true
            }else{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frmLay2, BlueFragment(), "BLUE")
                    .replace(R.id.frmLay1, RedFragment(), "RED")
                    .commit()
                cambio = false
            }
            //supportFragmentManager.beginTransaction().replace(R.id.frmLay1,BlueFragment(),"Blue").commit()
            //supportFragmentManager.beginTransaction().replace(R.id.frmLay2,BlueFragment(),"Rojo").commit()//remplaza fragment
            //supportFragmentManager.beginTransaction().add(R.id.frmLay1,BlueFragment(),"Blue").addToBackStack().commit()//agrega al
            //supportFragmentManager.beginTransaction() .add(R.id.frmLay1,BlueFragment(),"Blue").commit()//agrega al
            var fragmentos = supportFragmentManager.fragments
            fragmentos.forEach{
                supportFragmentManager.beginTransaction().remove(it).commit()
            }*/

        }
        binding.btnAmarillo.setOnClickListener{
            supportFragmentManager?.beginTransaction()?.
            add(R.id.frmLay4,YellowFragment(),"Amarillo")?.commit()
            colores[3] = "AMARILLO"
            binding.btnAmarillo.isEnabled = false
        }
        binding.btnCircular.setOnClickListener{
            var aux = colores[3]
            colores[3] = colores[2]
            colores[2] = colores[1]
            colores[1] = colores[0]
            colores[0] = aux
            Log.v("Arreglo",colores[0])
            Log.v("Arreglo",colores[1])
            Log.v("Arreglo",colores[2])
            Log.v("Arreglo",colores[3])

            for (i in 0..3){
                    when(i){
                        0->{ if(colores[i] == "AZUL"){
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.frmLay1, BlueFragment(), "BLUE")
                                .commit()
                            }else if(colores[i] == "ROJO"){
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay1, RedFragment(), "ROJO")
                                    .commit()
                            }else if(colores[i] == "AMARILLO"){
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay1, YellowFragment(), "YELLOW")
                                    .commit()
                            }else{
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay1, GreeFragment(), "GREEN")
                                    .commit()
                            }
                        }
                        1->{ if(colores[i] == "AZUL"){
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.frmLay2, BlueFragment(), "BLUE")
                                .commit()
                            }else if(colores[i] == "ROJO"){
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay2, RedFragment(), "ROJO")
                                    .commit()
                            }else if(colores[i] == "AMARILLO"){
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay2, YellowFragment(), "YELLOW")
                                    .commit()
                            }else{
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay2, GreeFragment(), "GREEN")
                                    .commit()
                            }
                        }
                        2->{ if(colores[i] == "AZUL"){
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.frmLay3, BlueFragment(), "BLUE")
                                .commit()
                            }else if(colores[i] == "ROJO"){
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay3, RedFragment(), "ROJO")
                                    .commit()
                            }else if(colores[i] == "AMARILLO"){
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay3, YellowFragment(), "YELLOW")
                                    .commit()
                            }else{
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay3, GreeFragment(), "GREEN")
                                    .commit()
                            }
                        }
                        3->{ if(colores[i] == "AZUL"){
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.frmLay4, BlueFragment(), "BLUE")
                                .commit()
                            }else if(colores[i] == "ROJO"){
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay4, RedFragment(), "ROJO")
                                    .commit()
                            }else if(colores[i] == "AMARILLO"){
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay4, YellowFragment(), "YELLOW")
                                    .commit()
                            }else{
                                supportFragmentManager.beginTransaction()
                                    .replace(R.id.frmLay4, GreeFragment(), "GREEN")
                                    .commit()
                            }
                        }
                    }
                }
            }
    }
}