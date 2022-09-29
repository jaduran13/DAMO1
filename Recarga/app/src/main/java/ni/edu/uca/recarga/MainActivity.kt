package ni.edu.uca.recarga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import ni.edu.uca.recarga.databinding.ActivityMainBinding
import ni.edu.uca.recarga.databinding.ItemListaBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var lista : ArrayList<Recarga>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciar()
    }

    private fun iniciar() {
        binding.btnAgregar.setOnClickListener {
            val num = binding.etNumero.text.toString()
            val monto = binding.etMonto.text.toString().toDouble()
            val recarga = Recarga(num, monto)
            lista.add(recarga)
        }
    }

}