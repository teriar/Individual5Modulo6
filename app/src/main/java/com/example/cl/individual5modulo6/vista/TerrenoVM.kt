package com.example.cl.individual5modulo6.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cl.individual5modulo6.data.Repositorio
import com.example.cl.individual5modulo6.data.remote.Terreno
import com.example.cl.individual5modulo6.data.remote.TerrenoRetrofit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application):AndroidViewModel(application){
       private  val repositorio:Repositorio
       val terrenosLiveData = MutableLiveData<List<Terreno>>()
       init {
           val api = TerrenoRetrofit.getRetrofitTerreno()
           repositorio = Repositorio(api)
       }

    fun getAllTerrenos() = viewModelScope.launch{
        terrenosLiveData.value =repositorio.cargarTerreno()

    }
}