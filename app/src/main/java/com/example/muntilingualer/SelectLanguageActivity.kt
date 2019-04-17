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

        val csv = CsvReader()
        val langList = csv.readLangualgeList(applicationContext)

        var course: SelectCourseItem
        var count = 1
        langList.forEach{
            course = SelectCourseItem()
            course.number = count
            course.title = it
            courseList.add(course)

            count++
        }

        courseItem["set"] = courseList
    }

}