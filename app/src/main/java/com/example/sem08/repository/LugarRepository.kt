package com.example.sem08.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sem08.data.LugarDAO
import com.example.sem08.model.Lugar

class LugarRepository(private val lugarDAO: LugarDAO) {
    fun guardarLugar(lugar: Lugar){
        lugarDAO.guardarLugar(lugar)
    }

    fun eliminarLugar(lugar: Lugar){
        lugarDAO.eliminarLugar(lugar)
    }

    val obtenerLugares: MutableLiveData<List<Lugar>> = lugarDAO.getLugares()
}