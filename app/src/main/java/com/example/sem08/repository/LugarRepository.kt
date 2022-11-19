package com.example.sem08.repository

import androidx.lifecycle.LiveData
import com.example.sem08.data.LugarDAO
import com.example.sem08.model.Lugar

class LugarRepository(private val lugarDAO: LugarDAO) {
    suspend fun guardarLugar(lugar: Lugar){
        if(lugar.id == 0){
           lugarDAO.agregarLugar(lugar)
        }
        else{
            lugarDAO.actualizarLugar(lugar)
        }
    }

    suspend fun eliminarLugar(lugar: Lugar){
        lugarDAO.eliminarLugar(lugar)
    }

    val obtenerLugares: LiveData<List<Lugar>> = lugarDAO.getLugares()
}