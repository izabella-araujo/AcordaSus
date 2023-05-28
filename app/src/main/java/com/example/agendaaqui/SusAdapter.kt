package com.example.agendaaqui.com.example.agendaaqui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agendaaqui.R


class SusAdapter(private val susList: ArrayList<ConsultaModelo>)  :
    RecyclerView.Adapter<SusAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lista_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentSus = susList[position]
        holder.tvSusEspecialidade.text = currentSus.susEspecialidade
    }

    override fun getItemCount(): Int {
        return susList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvSusEspecialidade : TextView = itemView.findViewById(R.id.tvSusEspecialidade)


    }
}