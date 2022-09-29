package ni.edu.uca.recarga.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.recarga.Recarga
import ni.edu.uca.recarga.databinding.ItemListaBinding

class RecargaAdapter(val lista: ArrayList<Recarga>):RecyclerView.Adapter<RecargaAdapter.RecargaHolder>(){
        inner class RecargaHolder(val binding:ItemListaBinding):
            RecyclerView.ViewHolder(binding.root){
            fun cargar(recarga:Recarga){
                binding.tvNumero.text= recarga.numero
                binding.tvMonto.text = recarga.monto.toString()
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecargaHolder {
        val binding=ItemListaBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return RecargaHolder(binding)
    }

    override fun onBindViewHolder(holder: RecargaHolder, position: Int) {
        holder.cargar(lista[position])
    }

    override fun getItemCount(): Int = lista.size

}