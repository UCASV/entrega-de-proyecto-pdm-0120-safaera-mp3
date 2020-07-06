package com.applendar.applendar.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

import com.applendar.applendar.R
import com.applendar.applendar.adapters.Activity
import com.applendar.applendar.adapters.AgendaAdapter
import kotlinx.android.synthetic.main.fragment_calendar.*

/**
 * A simple [Fragment] subclass.
 */
class CalendarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //============================activitites Rv
        //val recycler: RecyclerView = findViewById(R.id.recycler)
        //recycler.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL, false)
        act_recycler.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))

        val activities = ArrayList<Activity>()
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))
        activities.add(Activity("Examen","moviles","23/06/2020",R.drawable.quiz))


        val adapter = AgendaAdapter(activities)

        act_recycler.adapter=adapter

        //============================activitites Rv

        //============================

    }

}
