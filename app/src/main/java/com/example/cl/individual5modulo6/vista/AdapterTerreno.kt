package com.example.cl.individual5modulo6.vista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cl.individual5modulo6.R
import com.example.cl.individual5modulo6.data.local.TerrenoEntity
import com.example.cl.individual5modulo6.data.remote.Terreno
import com.example.cl.individual5modulo6.databinding.ItemTerrenoBinding

class AdapterTerreno: RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    private val listTerrenos = mutableListOf<TerrenoEntity>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTerreno.ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemTerrenoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterTerreno.ItemTerrenoViewHolder, position: Int) {
        val terreno = listTerrenos[position]
        holder.bind(terreno)
    }

    override fun getItemCount(): Int {
        return  listTerrenos.size
    }

    fun setData(terreno: List<TerrenoEntity>){
        this.listTerrenos.clear()
        this.listTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v:ItemTerrenoBinding):RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: TerrenoEntity) {
             v.imgTerreno.load(terreno.imagen)
            val bundle = Bundle()
            bundle.putString("id",terreno.id)
            //bundle.putString("imagen", terreno.imagen)
            //bundle.putString("precio",terreno.precio.toString())

            v.imgTerreno.setOnClickListener{
                Navigation.findNavController(v.root).navigate(R.id.action_listadoFragment_to_detalleFragment, bundle)
            }

        }
    }
}