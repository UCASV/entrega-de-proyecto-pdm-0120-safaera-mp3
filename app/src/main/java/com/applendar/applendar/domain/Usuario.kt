package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Usuario {

    @SerializedName("idUsuario")
    @Expose
    var idUsuario :Int?=null

    @SerializedName("usuario")
    @Expose
    var usuario :String?=null

    @SerializedName("puntaje")
    @Expose
    var puntaje :Int?=null



}