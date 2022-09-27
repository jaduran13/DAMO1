package ni.edu.uca.miuca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import ni.edu.uca.miuca.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mimenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnuConfig -> Toast.makeText(this, "Configuración",
                Toast.LENGTH_LONG).show()
            R.id.mnuInicio -> Toast.makeText(this, "Inicio",
                Toast.LENGTH_LONG).show()
        }

        return super.onOptionsItemSelected(item)
    }
}