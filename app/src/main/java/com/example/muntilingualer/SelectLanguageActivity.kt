package com.example.muntilingualer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class SelectLanguageActivity : AppCompatActivity() {
    private val courseItem = HashMap<String, ArrayList<SelectCourseItem>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_language)

        loadCourse()

        val lv = findViewById<ListView>(R.id.lView_select_language)
        val courses = getCourse("set")
        val courseAdapter = SelectCourseAdapter(courses, this)
        lv.adapter = courseAdapter

        lv.onItemClickListener = AdapterView.OnItemClickListener(function = { _, _, i, _ ->

            intent.putExtra("LANG", courses[i].title)
            setResult(intent.getIntExtra("btn_code", 0 ), intent)
            finish()
        })
    }

    private fun getCourse(courseName: String): ArrayList<SelectCourseItem>{
        val titleName = courseItem[courseName]
        return titleName ?: ArrayList()
    }

    private fun loadCourse() {
        addCourse(courseItem)
    }

    private fun addCourse(courseItem: MutableMap<String, ArrayList<SelectCourseItem>>){
        val courseList = ArrayList<SelectCourseItem>()

        var course = SelectCourseItem()
        course.number = 1
        course.title = "JPN"
        courseList.add(course)

        course = SelectCourseItem()
        course.number = 2
        course.title = "ENG"
        courseList.add(course)

        course = SelectCourseItem()
        course.number = 3
        course.title = "CNI"
        courseList.add(course)

        courseItem["set"] = courseList
    }

}