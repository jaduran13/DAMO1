package ni.edu.uca.listadoprod.dataadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.listadoprod.databinding.ItemlistaBinding
import ni.edu.uca.listadoprod.dataclass.Producto

class ProductoAdapter(
    private val listProd: List<Producto>,
    private val onClickListener: (Producto) -> Unit,
    private val onClickDelete:(Int)->Unit
) :
    RecyclerView.Adapter<ProductoAdapter.ProductoHolder>() {

    inner class ProductoHolder(val binding: ItemlistaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun cargar(
            producto: Producto,
            onClickListener: (Producto) -> Unit,
            onClickDelete: (Int) -> Unit
        ) {
            with(binding) {
                tvCodProd.text = producto.id.toString()
                tvNombreProd.text = producto.nombre
                tvPrecioProd.text = producto.precio.toString()
                //Seleccionar un producto dando clic
                itemView.setOnClickListener { onClickListener(producto)}
                binding.btnEliminar.setOnClickListener {
                    onClickDelete(adapterPosition)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        val binding = ItemlistaBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false
        )
        return ProductoHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        val item = listProd[position]
        holder.cargar(item, onClickListener, onClickDelete)
    }

    override fun getItemCount(): Int = listProd.size
}

