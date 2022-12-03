package com.example.sem08.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sem08.databinding.LugarFilaBinding
import com.example.sem08.model.Lugar
import com.example.sem08.ui.home.HomeFragmentDirections

class LugarAdapter: RecyclerView.Adapter<LugarAdapter.LugarViewHolder>() {

    //Lista de lugares
    private var listaLugares = emptyList<Lugar>()

    fun setLugares(lugares: List<Lugar>){
        listaLugares = lugares
        notifyDataSetChanged()
    }

    inner class LugarViewHolder(private val itemBinding: LugarFilaBinding)
        : RecyclerView.ViewHolder(itemBinding.root){
            fun dibuja(lugar: Lugar){
                itemBinding.tvNombre.text = lugar.nombre
                itemBinding.tvCorreo.text = lugar.correo
                itemBinding.tvTelefono.text = lugar.telefono

                if(lugar.rutaImagen?.isNotEmpty() == true){
                    Glide.with(itemBinding.root.context)
                        .load(lugar.rutaImagen)
                        .into(itemBinding.imagen)
                }

                //Evento enviar update
                itemBinding.vistaFila.setOnClickListener{
                    val accion = HomeFragmentDirections.actionNavHomeToUpdateLugarFragment(lugar)
                    itemView.findNavController().navigate(accion)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val itemBinding = LugarFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LugarViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = listaLugares[position]
        holder.dibuja(lugar)
    }

    override fun getItemCount(): Int {
        return listaLugares.size
    }


}