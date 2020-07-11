package com.applendar.applendar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.applendar.applendar.R
import com.applendar.applendar.domain.Materia

class MateriasAdapter(private val context: Context, private val materiasList: ArrayList<Materia>): BaseAdapter() {
    lateinit var mContext : Context;

    class MateriasViewHolder{
        var nombreMateria : TextView?=null;
        var acronimoMateria : TextView?=null;
        var catedratico : TextView?=null;
    }


    override fun getView(i: Int, view: View?, parent: ViewGroup?): View {
        val inflater : LayoutInflater = LayoutInflater.from(context);
        var viewHolder: MateriasViewHolder = MateriasViewHolder();

        var mView : View? = view;
        if(view == null){
            mView  = inflater.inflate(R.layout.materia_listview_element, parent, false);
            viewHolder.nombreMateria = mView.findViewById(R.id.materia_listview_element_materia);
            viewHolder.acronimoMateria = mView.findViewById(R.id.materia_listview_element_acronimo);
            viewHolder.catedratico = mView.findViewById(R.id.materia_listview_element_catedratico);
            mView.setTag(viewHolder);
        }
        else{
            viewHolder = view.getTag() as MateriasViewHolder;
        }
        val materia: Materia = materiasList.get(i);
        viewHolder.nombreMateria?.setText(materia.nombre!!);
        viewHolder.catedratico?.setText(materia.catedratico);
        viewHolder.acronimoMateria?.setText(materia.acronimo);

        return mView!!;
    }

    override fun getItem(i: Int): Any {
        return materiasList.get(i);
    }

    override fun getItemId(i: Int): Long {
        return 1
    }

    override fun getCount(): Int {
        return materiasList.size;
    }




}