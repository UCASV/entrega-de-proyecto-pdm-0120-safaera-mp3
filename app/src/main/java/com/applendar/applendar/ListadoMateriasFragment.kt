package com.applendar.applendar

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.Toolbar
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListadoMateriasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListadoMateriasFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var materiaslv: ListView;
    lateinit var adapter: MateriasAdapter
    lateinit var materias: ArrayList<Materia>;
    lateinit var materiasPerma: ArrayList<Materia>;
    lateinit var searchView: SearchView;
    lateinit var loadingModal: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        var mainActivity: MainActivity = (activity as MainActivity);
        (activity as MainActivity).setActionBarTitle("Materias")

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val obj = object: AsyncResponse{
            override fun processFinish() {
                println("Entered Async Response")
                loadingModal.visibility = View.GONE;
                adapter = MateriasAdapter(context!!, materias);
                materiaslv.adapter = adapter;
                materiasPerma = ArrayList<Materia>()
                materiasPerma.addAll(materias)
            }

            override fun alternativeFinish() {
                TODO("Not yet implemented")
            }
        }
         ClienteRequest(obj).execute()

        loadingModal = view!!.findViewById(R.id.listado_materias_loading_modal)
        loadingModal.visibility = View.VISIBLE
        materiaslv =  view!!.findViewById(R.id.fragment_listado_materias_listview)



        materiaslv.setOnItemClickListener { parent, view, position, id ->
            var materia: Materia = adapter.getItem(position) as Materia
            var intent: Intent = Intent(context!!, MateriaActivity::class.java)
            intent.putExtra("materia_nombre", materia.nombre)
            intent.putExtra("materia_acronimo", materia.acronimo)
            intent.putExtra("materia_catedratico", materia.catedratico)
            intent.putExtra("materia_id", materia.materiaId)
            startActivity(intent)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.searchbar_menu, menu)
        val searchItem: MenuItem? = menu?.findItem(R.id.action_buscar)
        if (searchItem != null) {
            searchView = MenuItemCompat.getActionView(searchItem) as SearchView
            searchView.setOnCloseListener(object : SearchView.OnCloseListener {
                override fun onClose(): Boolean {
                    return true
                }
            })

            val searchPlate = searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
            searchPlate.hint = "Search"
            val searchPlateView: View =
                searchView.findViewById(androidx.appcompat.R.id.search_plate)
            searchPlateView.setBackgroundColor(
                ContextCompat.getColor(
                    context!!,
                    android.R.color.transparent
                )
            )

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    var materiaSublist = ArrayList<Materia>()
                    if(query!= null ) {
                        if( query != "") {
                            for (materia: Materia in materiasPerma) {
                                if (materia.acronimo?.toLowerCase()?.contains(query.toLowerCase())!!
                                    || materia.nombre?.toLowerCase()
                                        ?.contains(query.toLowerCase())!!
                                ) {
                                    materiaSublist.add(materia)
                                }
                            }
                        }
                        else{
                            materiaSublist = materiasPerma
                        }
                    }
                    else{
                        materiaSublist = materiasPerma
                    }
                    materias.clear()
                    materias.addAll(materiaSublist)
                    adapter.notifyDataSetChanged()
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    var materiaSublist = ArrayList<Materia>()
                    if(newText==null){
                        materiaSublist = materiasPerma
                        materias.clear()
                        materias.addAll(materiaSublist)
                        adapter.notifyDataSetChanged()
                    }
                    else if(newText==""){
                        materiaSublist = materiasPerma
                        materias.clear()
                        materias.addAll(materiaSublist)
                        adapter.notifyDataSetChanged()
                    }

                    return false
                }
            })

            val searchManager = activity!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
            searchView.setSearchableInfo(searchManager.getSearchableInfo(activity!!.componentName))
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity!!.title = "Titulo"
        return inflater.inflate(R.layout.fragment_listado_materias, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListadoMateriasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListadoMateriasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    inner class ClienteRequest(callback: AsyncResponse) :
        AsyncTask<String?, Void?, ArrayList<Materia>>() {
        var delegate: AsyncResponse

        override fun onPostExecute(result: ArrayList<Materia>?) {
            delegate.processFinish()
        }

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
                materias = response.body()!!;
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