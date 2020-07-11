package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Usuario {

    @SerializedName("usuarioId")
    @Expose
    var usuarioId :Int?=null

    @SerializedName("usuario")
    @Expose
    var usuario :String?=null

    @SerializedName("pass")
    @Expose
    var pass :String?=null

    @SerializedName("imagen_de_perfil")
    @Expose
    var imagenDePerfil :Byte?=null

    @SerializedName("contribuciones")
    @Expose
    var contribuciones :Int?=null

    @SerializedName("email")
    @Expose
    var email :String?=null

    @SerializedName("apellido")
    @Expose
    var apellido :String?=null

    @SerializedName("nombre")
    @Expose
    var nombre :String?=null

}