package com.example.cl.individual5modulo6.data

import androidx.lifecycle.LiveData
import com.example.cl.individual5modulo6.data.local.TerrenoDao
import com.example.cl.individual5modulo6.data.local.TerrenoEntity
import com.example.cl.individual5modulo6.data.remote.Terreno
import com.example.cl.individual5modulo6.data.remote.TerrenoAPI
import com.example.cl.individual5modulo6.vista.TerrenoVM

class Repositorio(private val terrenoAPI: TerrenoAPI, private val terrenoDao: TerrenoDao) {

    fun obtenerTerrenos(): LiveData<List<TerrenoEntity>> = terrenoDao.getAllTerrenos()

    fun getTerreno(id:String):LiveData<TerrenoEntity> = terrenoDao.getTerreno(id)

    suspend fun cargarTerreno() {
        val response = terrenoAPI.getData()
        if (response.isSuccessful) {
            val resp = response.body()
            resp?.let { terrenos ->
                val terrenosEntity = terrenos.map { it.trasnformar() }
                terrenoDao.insertTerrenos(terrenosEntity)
            }
        }
    }
}

fun Terreno.trasnformar(): TerrenoEntity =
    TerrenoEntity(this.id, this.price.toInt(), this.type, this.img)