package com.example.aula7exercicio7

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val dataSet: MutableList<Pessoa>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo = view.findViewById<TextView>(R.id.titulo)
        val valor = view.findViewById<TextView>(R.id.valor)
        val foto = view.findViewById<ImageView>(R.id.imagem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.titulo.text = dataSet[position].titulo
        holder.valor.text = dataSet[position].descricao
        holder.foto.setImageResource(dataSet[position].foto)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun swapItems(fromPosition: Int, toPosition: Int) {
        val fromItem = dataSet[fromPosition]
        dataSet[fromPosition] = dataSet[toPosition]
        dataSet[toPosition] = fromItem
        notifyItemMoved(fromPosition, toPosition)
    }
}
