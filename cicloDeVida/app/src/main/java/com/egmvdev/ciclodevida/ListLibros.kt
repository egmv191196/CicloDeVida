package com.egmvdev.ciclodevida

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.egmvdev.ciclodevida.clases.ListaLibroAdaptador
import com.egmvdev.ciclodevida.clases1.AlumnoContract
import com.egmvdev.ciclodevida.databinding.ActivityListLibrosBinding
import com.egmvdev.ciclodevida.model.Alumno
import com.egmvdev.ciclodevida.model.Libro
import java.io.Serializable

class ListLibros : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    val DbHelper = AlumnoContract.AlumnoDbHelper(this)
    var color = true
    var arreglo = arrayListOf<Libro>()
    private lateinit var binding: ActivityListLibrosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListLibrosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*arreglo.add(Libro("Los hornos de Hitler","Olga Lengyel",289.00, R.drawable.hornos))
        arreglo.add(Libro("El diario de Ana Frank", "Ana Frank", 298.00, R.drawable.frank))
        arreglo.add(Libro("Preguntale a Alicia", "Anonimo", 77.00, R.drawable.alicia))
        arreglo.add(Libro("Los cuatro acuerdos", "Miguel Ángel Ruiz Macías", 280.00, R.drawable.cuatro))
        arreglo.add(Libro("Todo termina con nosotros", "Colleen Hoover", 358.00, R.drawable.termina))
        arreglo.add(Libro("El principito"," Antoine de Saint-Exupéry",289.00, R.drawable.principito))*/
        llenadoLibros()
        var adapter = ListaLibroAdaptador(this, arreglo)
        binding.LVLibros.adapter = adapter
        binding.LVLibros.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            var L: Libro = parent.getItemAtPosition(position) as Libro
            //Toast.makeText(this, L.Autor, Toast.LENGTH_SHORT).show()
            var intent: Intent = Intent(this, DetailBook::class.java)
            intent.putExtra("Title", L.Titulo)
            intent.putExtra("Autor", L.Autor)
            intent.putExtra("Precio", L.Precio)
            intent.putExtra("Img", L.imagenId)
            startActivity(intent)
        }
        binding.ButtonAdd.setOnClickListener {
            var intent: Intent = Intent(this, RegisterBook::class.java)
            //intent.putExtra(resources.getString(R.string.identificador),"RECEPTOR 0 DESDE COMUNICACION")
            //startActivity(intent)
            resultadoLanzador.launch(intent)
        }
        registerForContextMenu(binding.LVLibros)
        binding.ButtonAdd.setOnLongClickListener {
            mostrarMenuEmergente(it)
            true
        }

    }

    //Establece el menu de opciones del activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflador: MenuInflater = menuInflater
        inflador.inflate(R.menu.menu_opciones,menu)
        return true
    }
    //Escuchador de los items del menu de opciones
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.mnConfigurar->{
                var intent: Intent = Intent(this, preferencias::class.java)
                startActivity(intent)
                //Toast.makeText(this,"Opcion Configuar",Toast.LENGTH_SHORT).show()
                true
            }R.id.mnAyuda->{
                Toast.makeText(this,"Opcion Ayuda",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.mnSalir->{
                Toast.makeText(this,"Opcion Salir",Toast.LENGTH_SHORT).show()
                finish()
                true
            }
            R.id.mnAgregar->{
                var intent: Intent = Intent(this, RegisterBook::class.java)
                resultadoLanzador.launch(intent)
                true
            }
            else->{
                super.onOptionsItemSelected(item)
            }
        }
    }
    //Estableme el layout para menu contextual, por lo general se usa en listView
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflador = menuInflater
        inflador.inflate(R.menu.menu_contextual,menu)
    }
    //Escuchador de los item para el menu contextual
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when(item.itemId){
            R.id.iEditar->{
                var intent: Intent = Intent(this, RegisterBook::class.java)
                intent.putExtra("Bandera",true)
                intent.putExtra("Titulo",arreglo[info.position].Titulo)
                intent.putExtra("Autor",arreglo[info.position].Autor)
                intent.putExtra("Precio",arreglo[info.position].Precio.toString())
                intent.putExtra("Position",info.position.toString())
                //startActivity(intent)
                lanzadorEditar.launch(intent)
                //meter los datos en un intent y mandarlo al agreagr con una bandera
                //Toast.makeText(this,"Editar " + arreglo[info.position].Titulo,Toast.LENGTH_SHORT).show()
                true
            }
            R.id.iEliminar->{
                val db= DbHelper.writableDatabase
                val seleccion ="${AlumnoContract.Libro.TITULO} =?"
                val selectArgs = arrayOf(arreglo[info.position].Titulo)
                val filasBorradas = db.delete(AlumnoContract.Libro.NOMBRE_TABLA,seleccion,selectArgs)
                llenadoLibros()
                var adapter = ListaLibroAdaptador(this, arreglo)
                binding.LVLibros.adapter = adapter
                //arreglo.removeAt(info.position)

                //Toast.makeText(this,"Eliminar " + arreglo[info.position].Titulo,Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
    //Agrega un menu emergente a un objeto, puede ser cualquier objeto
    fun mostrarMenuEmergente(view: View){
        val emergente = PopupMenu(this,view)
        emergente.setOnMenuItemClickListener(this)
        val inflador = emergente.menuInflater
        inflador.inflate(R.menu.menu_emergente,emergente.menu)
        emergente.show()
    }
    //Escuchador del menu popup o emergente
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when(item?.itemId){
            R.id.iTexto->{
                if(binding.ButtonAdd.text.toString() == "ADD BOOK"){
                    binding.ButtonAdd.setText("AGREGAR LIBRO")
                    Toast.makeText(this,"Ingles",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Español",Toast.LENGTH_SHORT).show()
                    binding.ButtonAdd.setText("ADD BOOK")
                }

                true
            }
            R.id.iColor->{
                if(color == true){
                    binding.ButtonAdd.setBackgroundColor(resources.getColor(R.color.amarillo))
                    //Toast.makeText(this,"Se va a modificar el verde",Toast.LENGTH_SHORT).show()
                    color = false
                }else{
                    binding.ButtonAdd.setBackgroundColor(resources.getColor(R.color.verde))
                    //Toast.makeText(this,"Se va a modificar el color amarillo",Toast.LENGTH_SHORT).show()
                    color = true
                }
                true
            }
            R.id.iDeshabilitar->{
                if(binding.ButtonAdd.isEnabled == true){
                    binding.ButtonAdd.isEnabled = false
                }
                Toast.makeText(this,"Se va a deshabilitar",Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                false
            }
        }
    }

    var resultadoLanzador =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                resultado ->
            if (resultado.resultCode == Activity.RESULT_OK){
                val title = resultado.data?.getStringExtra("Title")?:"Vacio"//Obtiene el mensaje del activity que fue llamado
                val autor = resultado.data?.getStringExtra("Autor")?:"Vacio"
                val precio = resultado.data?.getStringExtra("Precio")?:"Vacio"
                val db = DbHelper.writableDatabase
                val valores = ContentValues().apply {
                    put(AlumnoContract.Libro.TITULO, title)
                    put(AlumnoContract.Libro.AUTOR, autor)
                    put(AlumnoContract.Libro.PRECIO, precio)
                    put(AlumnoContract.Libro.FOTO, R.drawable.hornos.toString())
                }
                val idAlumno = db.insert(AlumnoContract.Libro.NOMBRE_TABLA, null,valores)
                llenadoLibros()
                var adapter = ListaLibroAdaptador(this, arreglo)
                binding.LVLibros.adapter = adapter
                Toast.makeText(this, "Se agrego correctamente el libro $title  $autor $precio", Toast.LENGTH_LONG).show()
                //val mens = resultado.data?.getStringExtra("TEXTO_IDENTIFICADOR")?:"Vacio"//Obtiene el mensaje del activity que fue llamado
                //arreglo.add(Libro(title,autor,precio.toDouble(), R.drawable.hornos))
            }
            else{
                Toast.makeText(this, "Error al agregar", Toast.LENGTH_SHORT).show()
            }
        }

    var lanzadorEditar = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            resultado ->
        if (resultado.resultCode == Activity.RESULT_OK){
            val titleA = resultado.data?.getStringExtra("TitleA")?:"Vacio"//Obtiene el mensaje del activity que fue llamado
            val title = resultado.data?.getStringExtra("Title")?:"Vacio"//Obtiene el mensaje del activity que fue llamado
            val autor = resultado.data?.getStringExtra("Autor")?:"Vacio"
            val precio = resultado.data?.getStringExtra("Precio")?:"Vacio"
            val position = resultado.data?.getStringExtra("Position")?:"Vacio"

            val db = DbHelper.writableDatabase
            val valores = ContentValues().apply {
                put(AlumnoContract.Libro.TITULO, title)
                put(AlumnoContract.Libro.AUTOR, autor)
                put(AlumnoContract.Libro.PRECIO, precio)
            }
            val  seleccion = "${AlumnoContract.Libro.TITULO} = ?"
            val selectArgs = arrayOf(titleA)
            val filasActulizadas = db.update(AlumnoContract.Libro.NOMBRE_TABLA, valores,seleccion, selectArgs)
            llenadoLibros()
            var adapter = ListaLibroAdaptador(this, arreglo)
            binding.LVLibros.adapter = adapter
            //Toast.makeText(this,"Filas Actu",Toast.LENGTH_LONG).show()
            /*arreglo[position.toInt()].Titulo = title
            arreglo[position.toInt()].Autor = autor
            arreglo[position.toInt()].Precio = precio.toDouble()*/
            Toast.makeText(this, "Se modifico correctamente el libro $title  $autor $precio", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this, "Error al editar", Toast.LENGTH_SHORT).show()
        }
    }
    //Funcion para llenar el arreglo con los libros traidos de la base de datos
    fun llenadoLibros(){
        arreglo.clear()
        val db =DbHelper.readableDatabase
        val proyeccion = arrayOf(BaseColumns._ID,AlumnoContract.Libro.TITULO,AlumnoContract.Libro.AUTOR, AlumnoContract.Libro.PRECIO, AlumnoContract.Libro.FOTO)
        val cursor = db.query(AlumnoContract.Libro.NOMBRE_TABLA,proyeccion,null,null,null,null,null,null)
        with(cursor){
            while(moveToNext()){
                arreglo.add(
                    Libro(getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    getString(getColumnIndexOrThrow(AlumnoContract.Libro.TITULO)),
                    getString(getColumnIndexOrThrow(AlumnoContract.Libro.AUTOR)),
                    getString(getColumnIndexOrThrow(AlumnoContract.Libro.PRECIO)).toDouble(),
                    getString(getColumnIndexOrThrow(AlumnoContract.Libro.FOTO)).toInt())
                //Se lleno el arreglo con libros, tengo que agreagr los libros a el arreglo
                )
            }
        }
        for (libro in arreglo){
            Log.i("Titulo", libro.Titulo)
        }
    }
}