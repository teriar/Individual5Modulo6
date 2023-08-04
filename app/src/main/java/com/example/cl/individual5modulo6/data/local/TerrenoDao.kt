package com.example.cl.individual5modulo6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cl.individual5modulo6.data.remote.Terreno

@Dao
interface TerrenoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerreno(terrenoEntity:TerrenoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTerrenos(terrenoEntity: List<TerrenoEntity>)

    @Query("Select * from tabla_terreno order by id asc")
    fun getAllTerrenos(): LiveData<List<TerrenoEntity>>
}