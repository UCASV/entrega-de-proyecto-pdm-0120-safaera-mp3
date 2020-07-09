package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Comentario {

    @SerializedName("comentarioId")
    @Expose
    var comentarioId: Int?=null

    @SerializedName("comentario")
    @Expose
    var comentario: String?=null

    @SerializedName("fechaComentario")
    @Expose
    var fechaComentario: String?=null

    @SerializedName("usuario")
    @Expose
    var usuario: Usuario?=null

    @SerializedName("actividad")
    @Expose
    var actividad: Actividad?=null

}