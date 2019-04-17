package com.example.muntilingualer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop

class SelectCourseActivity : AppCompatActivity() {
    private val courseItem = HashMap<String, ArrayList<SelectCourseItem>>()

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_course)

        loadCourse()

        val lv = findViewById<ListView>(R.id.lView_course_list)
        val courses = getCourse("set")
        val courseAdapter = SelectCourseAdapter(courses, this)
        lv.adapter = courseAdapter

        lv.onItemClickListener = AdapterView.OnItemClickListener(function = { _, _, i, _ ->
            //Toast.makeText(this@SelectCourseActivity, "you selected " + (i + 1) + ":" + courses[i].title, Toast.LENGTH_LONG).show()

            val intent = Intent(this, PracticeActivity::class.java)
            intent.putExtra("CourseTitle", courses[i].title)
            startActivity(intent)
        })
    }

    fun getCourse(couseName: String): ArrayList<SelectCourseItem>{
        val titleName = courseItem[couseName]
        if (titleName != null) return titleName else return ArrayList<SelectCourseItem>()
    }

    fun loadCourse() {
        addCourse(courseItem)
    }

    fun addCourse(courseItem: MutableMap<String, ArrayList<SelectCourseItem>>){
        val courseList = ArrayList<SelectCourseItem>()

        var course = SelectCourseItem()
        course.number = 1
        course.title = "title001"
        courseList.add(course)

        course = SelectCourseItem()
        course.number = 2
        course.title = "title002"
        courseList.add(course)

        course = SelectCourseItem()
        course.number = 3
        course.title = "title003"
        courseList.add(course)

        courseItem["set"] = courseList
    }
}