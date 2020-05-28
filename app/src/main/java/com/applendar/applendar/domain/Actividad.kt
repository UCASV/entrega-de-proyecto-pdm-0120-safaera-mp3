package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Actividad {

    @SerializedName("idActividad")
    @Expose
    var idActividad: Int?=null

    @SerializedName("nombre")
    @Expose
    var nombre: String?=null

    @SerializedName("tipoDeActividad")
    @Expose
    var tipoDeActividad: String?=null

    @SerializedName("lugar")
    @Expose
    var lugar: String?=null

    @SerializedName("fechaDeActividad")
    @Expose
    var fechaDeActividad: String?=null

    @SerializedName("detalles")
    @Expose
    var detalles: Usuario?=null

    @SerializedName("autor")
    @Expose
    var autor: Usuario?=null

    @SerializedName("comentarios")
    @Expose
    var comentarios: List<Comentario>?=null
}