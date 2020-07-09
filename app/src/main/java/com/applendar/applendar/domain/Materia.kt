package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Materia {

    @SerializedName("materiaId")
    @Expose
    var materiaId: Int?=null

    @SerializedName("nombre")
    @Expose
    var nombre: String?=null

    @SerializedName("nombre")
    @Expose
    var descripcion: String?=null

    @SerializedName("catedratico")
    @Expose
    var catedratico: String?=null

    @SerializedName("acronimo")
    @Expose
    var acronimo: String?=null

    @SerializedName("ciclo")
    @Expose
    var ciclo: String?=null

    @SerializedName("fecha_de_finalizacion")
    @Expose
    var fechaDeFinalizacion: String?=null

    @SerializedName("actividades")
    @Expose
    var actividades: ArrayList<Actividad>?=null
}