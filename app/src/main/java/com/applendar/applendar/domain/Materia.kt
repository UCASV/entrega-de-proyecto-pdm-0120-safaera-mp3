package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Materia {

    @SerializedName("idMateria")
    @Expose
    val idMateria: Int?=null

    @SerializedName("nombre")
    @Expose
    val nombre: String?=null

    @SerializedName("nombre")
    @Expose
    val descripcion: String?=null

    @SerializedName("catedratico")
    @Expose
    val catedratico: String?=null
}