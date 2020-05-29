package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Actividad {

    @SerializedName("idActividad")
    @Expose
    val idActividad: Int?=null

    @SerializedName("nombre")
    @Expose
    val nombre: String?=null

    @SerializedName("tipoDeActividad")
    @Expose
    val tipoDeActividad: String?=null

    @SerializedName("lugar")
    @Expose
    val lugar: String?=null

    @SerializedName("fechaDeActividad")
    @Expose
    val fechaDeActividad: String?=null

    @SerializedName("detalles")
    @Expose
    val detalles: Usuario?=null

    @SerializedName("autor")
    @Expose
    val autor: Usuario?=null

    @SerializedName("comentarios")
    @Expose
    val comentarios: List<Comentario>?=null
}