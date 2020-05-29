package com.applendar.applendar

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import com.applendar.applendar.adapters.MateriasAdapter
import com.applendar.applendar.domain.Materia

class ListadoMateriasActivity : AppCompatActivity() {

    lateinit var materiaslv: ListView;
    lateinit var searchView: SearchView;
    lateinit var materias: ArrayList<Materia>;
    lateinit var materiasPerma: ArrayList<Materia>;
    lateinit var adapter: MateriasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_materias)
        materias = ArrayList<Materia>()
        var materia: Materia = Materia();
        materia.nombre = "Programación de Disp. Mov.";
        materia.acronimo = "PDM";
        materia.siguienteFechaEva = "28/05/20"
        materia.catedratico = "Lic. Nestor Aldana";
        materia.descripcion = "La materia de programación de dispositivos móviles, como su nombre lo dice, se enfoca en el desarrollo" +
                " de aplicaciones para dispositivos móviles, más especificamente en desarrollo para el sistema operativo Android."
        materias.add(materia);
        var materia2: Materia = Materia();
        materia2.nombre = "Programación N-Capas";
        materia2.acronimo = "NC";
        materia2.siguienteFechaEva = "30/05/20"
        materia.catedratico = "Lic. Juan Lozano";
        materia.descripcion = "La materia de programación n-capas se enfoca en el desarrollo de aplicaciones por layers o capas, para la" +
                " subdibición de labores entres los componentes de una aplicación"
        materias.add(materia2);
        var materia3: Materia = Materia();
        materia3.nombre = "Análisis Numérico";
        materia3.acronimo = "AN";
        materia3.siguienteFechaEva = "10/06/20"
        materia.catedratico = "Ing. Daniel Sosa";
        materia.descripcion = "La materia de análisis numérico tiene como objetivo mostrar al estudiantes los métodos de convergencia "+
                "de los algoritmos que se utilizan en el día a día."
        materias.add(materia3);
        var materia4: Materia = Materia();
        materia4.nombre = "Matemáticas 4";
        materia4.acronimo = "MAT4";
        materia4.siguienteFechaEva = "07/06/20"
        materia.catedratico = "Ing. Mauro Cortez";
        materia.descripcion = "La materia de matemáticas 4 se enfoca en campos en 3 dimensiones"
        materias.add(materia4);
        var materia5: Materia = Materia();
        materia5.nombre = "Matemáticas 3";
        materia5.acronimo = "MAT3";
        materia5.siguienteFechaEva = "07/06/20"
        materia.catedratico = "Ing. Daniel Sosa";
        materia.descripcion = "La materia de matemáticas 3 se enfoca en interpolares y campos en 3 dimensiones"
        materias.add(materia5);
        var materia6: Materia = Materia();
        materia6.nombre = "Matemáticas 2";
        materia6.acronimo = "MAT2";
        materia6.siguienteFechaEva = "07/06/20"
        materia.catedratico = "Ing. Enrique Arguello";
        materia.descripcion = "La materia de matemáticas 2 ve temas como las integrales y solidos de revolución"
        materias.add(materia6);

        materiaslv = findViewById(R.id.activity_listado_materias_listview);
        adapter = MateriasAdapter(this, materias);
        materiaslv.adapter = adapter;
        materiasPerma = ArrayList<Materia>()
        materiasPerma.addAll(materias)

        materiaslv.setOnItemClickListener { parent, view, position, id ->
            var materia: Materia = adapter.getItem(position) as Materia
            var intent: Intent = Intent(applicationContext, MateriaActivity::class.java)
            intent.putExtra("materia_nombre", materia.nombre)
            intent.putExtra("materia_acronimo", materia.acronimo)
            intent.putExtra("materia_siguienteFechaEva", materia.siguienteFechaEva)
            intent.putExtra("materia_catedratico", materia.catedratico)
            intent.putExtra("materias_descripcion", materia.descripcion)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.searchbar_menu, menu)
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
                    this,
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

            val searchManager =
                getSystemService(Context.SEARCH_SERVICE) as SearchManager
            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return super.onCreateOptionsMenu(menu)
    }


    override fun onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.onActionViewCollapsed();
        } else {
            super.onBackPressed();
        }
    }
}
