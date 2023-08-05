package com.example.cl.individual5modulo6.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.cl.individual5modulo6.R
import com.example.cl.individual5modulo6.databinding.FragmentDetalleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"




class DetalleFragment : Fragment() {
    private val terrenoVM: TerrenoVM by activityViewModels()
    private lateinit var binding:FragmentDetalleBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetalleBinding.inflate(layoutInflater,container,false)
        //
        terrenoVM.getTerrenos(param1.toString()).observe(viewLifecycleOwner){
            binding.txtId.text = it.id
            binding.imageView.load(it.imagen)
            binding.txtType.text = it.tipo
            binding.txtPrecio.text = it.precio.toString()
        }
        return binding.root

    }


    }
