package com.applendar.applendar.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Comentario {

    @SerializedName("idComentario")
    @Expose
    val idComentario: Int?=null

    @SerializedName("comentario")
    @Expose
    val comentario: Usuario?=null

    @SerializedName("fechaCreacion")
    @Expose
    val fechaCreacion: Usuario?=null

    @SerializedName("autor")
    @Expose
    val autor: Usuario?=null

}