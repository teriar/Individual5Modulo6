package com.example.cl.individual5modulo6.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cl.individual5modulo6.data.remote.Terreno
import com.example.cl.individual5modulo6.databinding.ItemTerrenoBinding

class AdapterTerreno: RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {

    lateinit var binding: ItemTerrenoBinding
    private val listTerrenos = mutableListOf<Terreno>()


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

    fun setData(terreno: List<Terreno>){
        this.listTerrenos.clear()
        this.listTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v:ItemTerrenoBinding):RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: Terreno) {
             v.imgTerreno.load(terreno.img)
        }
    }
}