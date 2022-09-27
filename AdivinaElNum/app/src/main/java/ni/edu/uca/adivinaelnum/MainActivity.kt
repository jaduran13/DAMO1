package ni.edu.uca.adivinaelnum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import ni.edu.uca.adivinaelnum.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniciar()
    }

    private fun iniciar() {
        var num :Int= 0
        binding.btnGenerar.setOnClickListener {
            num = generarNum()
            binding.tvNum.text = "?"
            binding.etNumero.setText("")
            binding.etNumero.requestFocus()
        }

        binding.btnAdivinar.setOnClickListener {
            validarNum(num)
        }
    }

    fun generarNum():Int = (0..9).random()

    fun validarNum(num:Int){
        val numUser: Int = binding.etNumero.text.toString().toInt()
        binding.tvNum.text= num.toString()
        if(num == numUser){
            Toast.makeText(this, "Usted ha adivinado el número, Felicidades...",
                Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Lo siento, ha perdido... ",
                Toast.LENGTH_LONG).show()
        }
    }
}
