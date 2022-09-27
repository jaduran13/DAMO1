package ni.edu.uca.listadoprod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ni.edu.uca.listadoprod.dataadapter.ProductoAdapter
import ni.edu.uca.listadoprod.databinding.ActivityMainBinding
import ni.edu.uca.listadoprod.dataclass.Producto


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductoAdapter
    private var listaProductos = ArrayList<Producto>()
    private var posicion: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciar()
    }

    private fun limpiar() {
        with(binding) {
            etID.setText("")
            etNombreProd.setText("")
            etPrecio.setText("")
            btnAgregar.setText("Agregar")
            etID.requestFocus()
        }
    }

    private fun agregarProd() {
        with(binding) {
            try {
                val id: Int = etID.text.toString().toInt()
                val nombre: String = etNombreProd.text.toString()
                val precio: Double = etPrecio.text.toString().toDouble()
                val prod = Producto(id, nombre, precio)
                listaProductos.add(prod)
            } catch (ex: Exception) {
                Toast.makeText(
                    this@MainActivity, "Error: ${ex.toString()} ",
                    Toast.LENGTH_LONG
                ).show()
            }
            llenarRcv()
            limpiar()
        }
    }

    private fun llenarRcv() {
        val manager = LinearLayoutManager(this)
        val decoracion = DividerItemDecoration(this, manager.orientation)
        adapter = ProductoAdapter(
            listProd = listaProductos,
            onClickListener = { producto -> seleccionarItem(producto) },
            onClickDelete = { pos -> eliminar(pos) }
        )

        binding.rcvLista.layoutManager = manager
        binding.rcvLista.adapter = adapter
        binding.rcvLista.addItemDecoration(decoracion)

    }

    private fun seleccionarItem(producto: Producto) {
        binding.etID.setText(producto.id.toString())
        binding.etNombreProd.setText(producto.nombre)
        binding.etPrecio.setText(producto.precio.toString())
        posicion = listaProductos.indexOf(producto)
        binding.btnAgregar.setText("Editar")
    }

    private fun iniciar() {
        binding.btnAgregar.setOnClickListener {
            if (binding.btnAgregar.text.equals("Agregar")) {
                agregarProd()
            } else if (binding.btnAgregar.text.equals("Editar")) {
                editar()
            }

        }
        binding.btnLimpiar.setOnClickListener {
            limpiar()
        }

    }

    private fun eliminar(posicion: Int) {
        listaProductos.removeAt(posicion)
        adapter.notifyItemRemoved(posicion)

    }

    private fun editar() {
        with(binding) {
            try {
                val id: Int = etID.text.toString().toInt()
                val nombre: String = etNombreProd.text.toString()
                val precio: Double = etPrecio.text.toString().toDouble()
                val prod = Producto(id, nombre, precio)
                listaProductos.set(posicion, prod)
                adapter.notifyItemChanged(posicion)
            } catch (ex: Exception) {
                Toast.makeText(
                    this@MainActivity, "Error: ${ex.toString()} ",
                    Toast.LENGTH_LONG
                ).show()
            }
            llenarRcv()
            limpiar()
        }
    }
}