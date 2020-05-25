package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Usuario {

    @SerializedName("idUsuario")
    @Expose
    val idUsuario :Int?=null

    @SerializedName("usuario")
    @Expose
    val usuario :String?=null

    @SerializedName("puntaje")
    @Expose
    val puntaje :Int?=null




}