package com.example.muntilingualer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class CourseListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemArray = ArrayList<String>()
        itemArray.add("course1")
        itemArray.add("course2")
        itemArray.add("course3")

        val adapter = ArrayAdapter(this.context, android.R.layout.simple_list_item_1, itemArray)
        val listView = view.findViewById<ListView>(R.id.lView_course_list)
        listView.adapter = adapter


    }
}
