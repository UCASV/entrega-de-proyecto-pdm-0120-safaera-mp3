package com.applendar.applendar

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import com.applendar.applendar.adapters.MateriasAdapter
import com.applendar.applendar.domain.Materia
import com.applendar.applendar.retrofit.APIEndpoint
import com.applendar.applendar.retrofit.AsyncResponse
import com.applendar.applendar.util.GeneralGlobalVariables

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ListadoMateriasActivity : AppCompatActivity() {

    lateinit var materiaslv: ListView;
    lateinit var searchView: SearchView;
    lateinit var materias: ArrayList<Materia>;
    lateinit var materiasPerma: ArrayList<Materia>;
    lateinit var adapter: MateriasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.onActionViewCollapsed();
        } else {
            super.onBackPressed();
        }
    }

    class ClienteRequest(callback: AsyncResponse) :
        AsyncTask<String?, Void?, kotlin.collections.ArrayList<Materia>>() {
        var delegate: AsyncResponse


        override fun doInBackground(vararg p0: String?): ArrayList<Materia>? {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor).build()
            val BASE_URL: String = GeneralGlobalVariables.BASE_URL
            val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val apiService: APIEndpoint = retrofit.create(APIEndpoint::class.java)

            /*val encoder = Encoder()
            val usuario = prefs.getString(LoginActivity.USERNAME, null)
            val password = prefs.getString(LoginActivity.PASSWORD, null)
            val encodedString: String = encoder.encoder64(usuario, password)*/
            val request: Call<ArrayList<Materia>> =
                apiService.getMaterias()
            val response: Response<ArrayList<Materia>>
            try {
                response = request.execute()
                println("Request for location done")
                return response.body()
            } catch (e: IOException) {
                println(e.message)
            }
            return null
        }


        init {
            delegate = callback
        }

    }
}
