package com.applendar.applendar.retrofit

import com.applendar.applendar.domain.Actividad
import com.applendar.applendar.domain.Materia
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIEndpoint {


    @GET("/actividad/")
    fun getActividades(@Query("materiaId") materiaId: Integer):Call<ArrayList<Actividad>>

    @GET("/materia/")
    fun getMaterias():Call<ArrayList<Materia>>
}