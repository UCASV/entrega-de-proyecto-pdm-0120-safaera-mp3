package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Materia {

    @SerializedName("idMateria")
    @Expose
    var idMateria: Int?=null

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

    @SerializedName("siguienteFecha")
    @Expose
    var siguienteFechaEva: String?=null
}