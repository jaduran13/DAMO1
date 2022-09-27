package ni.edu.uca.miuca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.miuca.databinding.ActivityMainBinding
import ni.edu.uca.miuca.databinding.ActivityMenuBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val user = "jadg13"
    private val pw = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciar()
    }

    private fun iniciar(){
        binding.btnEntrar.setOnClickListener {
            val id = binding.etUser.text.toString()
            val pw = binding.etPw.text.toString()
            validarUsuario(id, pw)
        }
    }

    private fun validarUsuario(id: String, pw: String) {
        if(this.user.equals(id) and this.pw.equals(pw)){
            val newPant :Intent = Intent(this, Menu::class.java)
            startActivity(newPant)
        }else{
            Toast.makeText(this, "Datos incorrectos...",
                Toast.LENGTH_LONG).show()
        }
    }

}