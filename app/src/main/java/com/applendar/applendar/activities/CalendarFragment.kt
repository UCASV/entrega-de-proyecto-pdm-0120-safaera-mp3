package com.applendar.applendar.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

import com.applendar.applendar.R
import com.applendar.applendar.adapters.Activity
import com.applendar.applendar.adapters.AgendaAdapter
import com.applendar.applendar.databinding.FragmentCalendarBinding
import com.applendar.applendar.databinding.FragmentPresentationBinding
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import kotlinx.android.synthetic.main.fragment_calendar.*
import org.threeten.bp.LocalDate
import org.threeten.bp.YearMonth
import org.threeten.bp.format.DateTimeFormatter
//==

//import android.os.Bundle
//import android.view.LayoutInflater
///import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
import androidx.core.view.children
import androidx.core.view.isVisible
//import androidx.fragment.app.Fragment
import com.applendar.applendar.activities.daysOfWeekFromLocale
import com.applendar.applendar.activities.makeInVisible
import com.applendar.applendar.activities.makeVisible
import com.applendar.applendar.activities.setTextColorRes
//import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.CalendarMonth
//import com.kizitonwose.calendarview.model.DayOwner
//import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import com.applendar.applendar.databinding.Example3CalendarDayBinding
import com.applendar.applendar.databinding.Example3CalendarHeaderBinding
import com.applendar.applendar.databinding.Example3FragmentBinding
//import org.threeten.bp.LocalDate
//import org.threeten.bp.YearMonth
//import org.threeten.bp.format.DateTimeFormatter

data class Event(val id: String, val text: String, val date: LocalDate)

//==
/**
 * A simple [Fragment] subclass.
 */
class CalendarFragment : Fragment() {

    private var selectedDate: LocalDate? = null
    private val today = LocalDate.now()

    private val titleSameYearFormatter = DateTimeFormatter.ofPattern("MMMM")
    private val titleFormatter = DateTimeFormatter.ofPattern("MMM yyyy")
    private val selectionFormatter = DateTimeFormatter.ofPattern("d MMM yyyy")
    private val events = mutableMapOf<LocalDate, List<Event>>()
    //private lateinit var binding: Example3FragmentBinding


    private lateinit var binding: FragmentCalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentCalendarBinding>(inflater,
            R.layout.fragment_calendar, container, false)
//            R.layout.example_3_fragment, container, false)
        //return inflater.inflate(R.layout.fragment_calendar, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        // Add Listener in calendar
//        binding.calendarView.setOnDateChangeListener{ view, year, month, dayOfMonth ->
//            val msg = dayOfMonth.toString() +"/"+(month+1)+"/"+year
//            //Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
//            binding.textView5.text = msg
//        }


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




        val daysOfWeek = daysOfWeekFromLocale()
        val currentMonth = YearMonth.now()
        binding.exThreeCalendar.apply {

            setup(currentMonth.minusMonths(10), currentMonth.plusMonths(10), daysOfWeek.first())
            scrollToMonth(currentMonth)
        }

        if (savedInstanceState == null) {
            binding.exThreeCalendar.post {
                // Show today's events initially.
                selectDate(today)
            }
        }

        class DayViewContainer(view: View) : ViewContainer(view) {
            lateinit var day: CalendarDay // Will be set when this container is bound.
            val binding = Example3CalendarDayBinding.bind(view)

            init {
                view.setOnClickListener {
                    if (day.owner == DayOwner.THIS_MONTH) {
                        selectDate(day.date)
                    }
                }
            }

        }

        binding.exThreeCalendar.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.day = day
                val textView = container.binding.exThreeDayText
                val dotView = container.binding.exThreeDotView

                textView.text = day.date.dayOfMonth.toString()

                if (day.owner == DayOwner.THIS_MONTH) {
                    textView.makeVisible()
                    when (day.date) {
                        today -> {
                            textView.setTextColorRes(R.color.example_3_white)
                            textView.setBackgroundResource(R.drawable.example_3_today_bg)
                            dotView.makeInVisible()
                        }
                        selectedDate -> {
                            textView.setTextColorRes(R.color.example_3_blue)
                            textView.setBackgroundResource(R.drawable.example_3_selected_bg)
                            dotView.makeInVisible()
                        }
                        else -> {
                            textView.setTextColorRes(R.color.example_3_black)
                            textView.background = null
                            dotView.isVisible = events[day.date].orEmpty().isNotEmpty()
                        }
                    }
                } else {
                    textView.makeInVisible()
                    dotView.makeInVisible()
                }
            }
        }

        binding.exThreeCalendar.monthScrollListener = {
//            homeActivityToolbar.title = if (it.year == today.year) {
//                titleSameYearFormatter.format(it.yearMonth)
//            } else {
//                titleFormatter.format(it.yearMonth)
//            }

            // Select the first day of the month when
            // we scroll to a new month.
            selectDate(it.yearMonth.atDay(1))
        }

        class MonthViewContainer(view: View) : ViewContainer(view) {
            val legendLayout = Example3CalendarHeaderBinding.bind(view).legendLayout.root
        }
        binding.exThreeCalendar.monthHeaderBinder =
            object : MonthHeaderFooterBinder<MonthViewContainer> {
                override fun create(view: View) = MonthViewContainer(view)
                override fun bind(container: MonthViewContainer, month: CalendarMonth) {
                    // Setup each header day text if we have not done that already.
                    if (container.legendLayout.tag == null) {
                        container.legendLayout.tag = month.yearMonth
                        container.legendLayout.children.map { it as TextView }
                            .forEachIndexed { index, tv ->
                                tv.text = daysOfWeek[index].name.first().toString()
                                tv.setTextColorRes(R.color.example_3_black)
                            }
                    }
                }
            }
    }

    private fun selectDate(date: LocalDate) {
        if (selectedDate != date) {
            val oldDate = selectedDate
            selectedDate = date
            oldDate?.let { binding.exThreeCalendar.notifyDateChanged(it) }
            binding.exThreeCalendar.notifyDateChanged(date)
            updateAdapterForDate(date)
        }
    }
    //
//    private fun saveEvent(text: String) {
//        if (text.isBlank()) {
//            Toast.makeText(requireContext(), R.string.example_3_empty_input_text, Toast.LENGTH_LONG).show()
//        } else {
//            selectedDate?.let {
//                events[it] = events[it].orEmpty().plus(Event(UUID.randomUUID().toString(), text, it))
//                updateAdapterForDate(it)
//            }
//        }
//    }
//
//    private fun deleteEvent(event: Event) {
//        val date = event.date
//        events[date] = events[date].orEmpty().minus(event)
//        updateAdapterForDate(date)
//    }
//
    private fun updateAdapterForDate(date: LocalDate) {
//        eventsAdapter.apply {
//            events.clear()
//            events.addAll(this@Example3Fragment.events[date].orEmpty())
//            notifyDataSetChanged()
//        }
        binding.exThreeSelectedDateText.text = selectionFormatter.format(date)
    }
//
//    override fun onStart() {
//        super.onStart()
//        homeActivityToolbar.setBackgroundColor(requireContext().getColorCompat(R.color.example_3_toolbar_color))
//        requireActivity().window.statusBarColor = requireContext().getColorCompat(R.color.example_3_statusbar_color)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        homeActivityToolbar.setBackgroundColor(requireContext().getColorCompat(R.color.colorPrimary))
//        requireActivity().window.statusBarColor = requireContext().getColorCompat(R.color.colorPrimaryDark)
//    }
}
