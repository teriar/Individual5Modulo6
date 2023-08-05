package com.example.cl.individual5modulo6.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cl.individual5modulo6.data.Repositorio
import com.example.cl.individual5modulo6.data.local.TerrenoDatabase
import com.example.cl.individual5modulo6.data.remote.Terreno
import com.example.cl.individual5modulo6.data.remote.TerrenoRetrofit
import kotlinx.coroutines.launch

class TerrenoVM(application: Application):AndroidViewModel(application){
       private  val repositorio:Repositorio
       fun terrenosLiveData() = repositorio.obtenerTerrenos()
       init {
           val api = TerrenoRetrofit.getRetrofitTerreno()
           val terrenoDataBase = TerrenoDatabase.getDataBase(application).getTerrenoDao()
           repositorio = Repositorio(api,terrenoDataBase)
       }

    fun getAllTerrenos() = viewModelScope.launch{
        repositorio.cargarTerreno()

    }
    fun getTerrenos(id:String) = repositorio.getTerreno(id)

}