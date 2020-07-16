package com.applendar.applendar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.applendar.applendar.R
import com.applendar.applendar.domain.Actividad
import com.applendar.applendar.domain.Materia
import com.bumptech.glide.Glide

//class Activity(var name:String, var materia:String, var date:String, var thumbnail:Int)

class AgendaAdapter(var list: ArrayList<Actividad>):RecyclerView.Adapter<AgendaAdapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bindItems(data:Actividad){
            val title:TextView = itemView.findViewById(R.id.name)
            val materiaStr:TextView = itemView.findViewById(R.id.materia)
            val date:TextView = itemView.findViewById(R.id.date)
            //val thumbnail:ImageView = itemView.findViewById(R.id.thumbnail)

            title.text = data.nombre
//            materiaStr.text = data.materia?.nombre
//            date.text = data.fechaDeEvaluacion

            //Glide.with(itemView.context).load(data.thumbnail).into(thumbnail)

//            itemView.setOnClickListener{
//                Toast.makeText(itemView.context,"Album de ${data.name}",Toast.LENGTH_LONG)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activities_rv_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }
}