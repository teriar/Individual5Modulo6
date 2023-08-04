package com.example.cl.individual5modulo6.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.cl.individual5modulo6.databinding.FragmentListadoBinding


class ListadoFragment : Fragment() {
     lateinit var  binding:FragmentListadoBinding
     private val terrenoVM: TerrenoVM by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListadoBinding.inflate(layoutInflater, container,false)
        initAdapter()
        binding.btnCargar.setOnClickListener{
            terrenoVM.getAllTerrenos()
        }
        return binding.root
    }

    private fun initAdapter() {
       // terrenoVM.getAllTerrenos()
        val adapter = AdapterTerreno()
       binding.recyclerView.adapter = adapter
        terrenoVM.terrenosLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }


}
