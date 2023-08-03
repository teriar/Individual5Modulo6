package com.example.cl.individual5modulo6.data

import com.example.cl.individual5modulo6.data.remote.Terreno
import com.example.cl.individual5modulo6.data.remote.TerrenoAPI

class Repositorio(private val terrenoAPI: TerrenoAPI) {

    suspend fun  cargarTerreno():List<Terreno>{
          val response = terrenoAPI.getData()
        if(response.isSuccessful){
          val resp =   response.body()
                resp?.let {
                return it
            }
        }
        return emptyList()
    }
}