package com.applendar.applendar

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applendar.applendar.domain.Actividad
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

class MateriaActivity : AppCompatActivity() {
    lateinit var materiaId: Integer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materia)
        materiaId = intent!!.extras?.get("materia_id") as Integer
        var obj = object: AsyncResponse{
            override fun processFinish() {

            }

            override fun alternativeFinish() {
            }

        }
        ActividadesRequest(obj).execute()

    }

    inner class ActividadesRequest(callback: AsyncResponse) :
        AsyncTask<String?, Void?, ArrayList<Actividad>>() {
        var delegate: AsyncResponse

        override fun onPostExecute(result: ArrayList<Actividad>?) {
            delegate.processFinish()
        }

        override fun doInBackground(vararg p0: String?): ArrayList<Actividad>? {
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
            val request: Call<ArrayList<Actividad>> =
                apiService.getActividades(materiaId)
            val response: Response<ArrayList<Actividad>>
            try {
                response = request.execute()
                //materias = response.body()!!;
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
