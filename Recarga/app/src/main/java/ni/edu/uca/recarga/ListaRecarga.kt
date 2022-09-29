package ni.edu.uca.recarga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ListaRecarga : AppCompatActivity() {
    private lateinit var  lista: ArrayList<Recarga>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_recarga)
    }
}