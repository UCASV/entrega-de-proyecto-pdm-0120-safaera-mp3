package com.applendar.applendar.retrofit.Models

import com.applendar.applendar.domain.Actividad
import com.applendar.applendar.retrofit.models.Post
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class RetrofitClass {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://moviles-sharemy10.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create<MetodosRetrofit>(MetodosRetrofit::class.java)


    interface MetodosRetrofit{

        @GET("/usuario/")
        fun GetAllPost(): Call<List<Post>>

        //GET y POST para usuario que es el ID de la persona (o eso creo)
        @GET("/usuario/{usuario}")
        fun GetPostByUsurio(@Path("usuario") usuario: String):Call<Post>

        @POST("/usuario/save")
        fun EditPostUsuario(@Path("usuario")usuario: String, @Body post: Post?): Call<Post>


        //GET y POST para el nombre del usuario (o eso creo)
        @GET("/usuario/{usuario}")
        fun GetPostByNombre(@Path("nombre") nombre: String):Call<Post>

        @POST("/usuario/save")
        fun EditPostNombre(@Path("nombre")nombre: String, @Body post: Post?): Call<Post>


        //GET y POST para el Apellido del usuario (o eso creo)
        @GET("/usuario/{usuario}")
        fun GetPostByApellido(@Path("apellido") apellido: String):Call<Post>

        @POST("/usuario/save")
        fun EditPostApellido(@Path("apellido") apellido: String, @Body post: Post?): Call<Post>


        //GET y POST para el Apellido del usuario (o eso creo)
        @GET("/usuario/{usuario}")
        fun GetPostByEmail(@Path("email") email: String):Call<Post>

        @POST("/usuario/save")
        fun EditPostEmail(@Path("email") email: String, @Body post: Post?): Call<Post>

        //GET y POST para el Apellido del usuario (o eso creo)
        @GET("/usuario/{usuario}")
        fun GetPostByPassword(@Path("Password") Password: String):Call<Post>

        @POST("/usuario/save")
        fun EditPostPassword(@Path("password") password: String, @Body post: Post?): Call<Post>
    }



}