package ni.edu.uca.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniciar()
    }

    private fun iniciar() {
        binding.btnSuma.setOnClickListener {
            val num1 :Int = binding.etNum1.text.toString().toInt()
            val num2 :Int = binding.etNum2.text.toString().toInt()
            val op = Operacion(num1, num2)
            val suma = op.sumar()
            binding.tvResult.text = suma.toString()
        }

        binding.btnResta.setOnClickListener {
            val n1 : Int = binding.etNum1.text.toString().toInt()
            val n2 : Int = binding.etNum2.text.toString().toInt()
            val op = Operacion(n1, n2)
            binding.tvResult.text = op.restar().toString()
        }

        binding.btnProd.setOnClickListener {
            val n1 = binding.etNum1.text.toString().toInt()
            val n2 = binding.etNum2.text.toString().toInt()
            val op = Operacion(n1, n2)
            binding.tvResult.text = op.multiplicar().toString()
        }

        binding.btnDiv.setOnClickListener {
            val op = Operacion(binding.etNum1.text.toString().toInt(),
            binding.etNum2.text.toString().toInt())
            binding.tvResult.text = op.dividir().toString()
        }


    }
}