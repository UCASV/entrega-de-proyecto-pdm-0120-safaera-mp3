package com.applendar.applendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import com.applendar.applendar.adapters.MateriasAdapter
import com.applendar.applendar.domain.Materia

class ListadoMateriasActivity : AppCompatActivity() {

    lateinit var materiaslv: ListView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_materias)

        var materias : ArrayList<Materia> = ArrayList();
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
        materia.descripcion = "La materia de matemáticas 2 ve temas como las integrales así como solidos de revolución"
        materias.add(materia6);

        materiaslv = findViewById(R.id.activity_listado_materias_listview);
        val adapter: MateriasAdapter = MateriasAdapter(this, materias);
        materiaslv.adapter = adapter;

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
}
