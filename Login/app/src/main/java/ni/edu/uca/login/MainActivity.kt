package ni.edu.uca.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    val codigo = "duran"
    val strPw = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iniciar()
    }

    fun iniciar(){
        binding.btnOk.setOnClickListener {
            val id = binding.etUser.text.toString()
            val pw = binding.etPw.text.toString()
            validarCredenciales(id, pw)
        }

    }

    private fun validarCredenciales( id:String,  pw:String) {
        if (id.equals(codigo) && pw.equals(strPw)){
            Toast.makeText(this, "Bienvenido",
                Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Error en credenciales",
            Toast.LENGTH_LONG).show()
        }
    }
}