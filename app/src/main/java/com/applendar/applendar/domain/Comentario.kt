package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Comentario {

    @SerializedName("idComentario")
    @Expose
    var idComentario: Int?=null

    @SerializedName("comentario")
    @Expose
    var comentario: Usuario?=null

    @SerializedName("fechaCreacion")
    @Expose
    var fechaCreacion: Usuario?=null

    @SerializedName("autor")
    @Expose
    var autor: Usuario?=null

}