package com.example.muntilingualer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView as ListView1

class SelectCourseActivity : AppCompatActivity() {
    private val courseItem = HashMap<String, ArrayList<SelectCourseItem>>()
    private lateinit var global : Global

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_course)

        global = this.application as Global
        loadCourse()

        val lv = findViewById<ListView1>(R.id.lView_course_list)
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

    private fun getCourse(courseName: String): ArrayList<SelectCourseItem>{
        val titleName = courseItem[courseName]
        if (titleName != null) {
            return titleName
        } else {
            return ArrayList<SelectCourseItem>()
        }
    }

    private fun loadCourse() {
        addCourse(courseItem)
    }

    private fun addCourse(courseItem: MutableMap<String, ArrayList<SelectCourseItem>>){
        val courseList = ArrayList<SelectCourseItem>()

        val csv = CsvReader()
        val courseListData: MutableMap<String, MutableMap<String, String>> = csv.readCourseList(applicationContext, "COURSE_LIST")

        var course: SelectCourseItem

        courseListData.forEach { (t, u) ->
            Log.d("forEach", t)
            Log.d("forEach", u.toString())
            course = SelectCourseItem()
            course.number = t.toInt()
            course.title = u[global.gFromLang]
            courseList.add(course)
        }

        courseItem["set"] = courseList
    }
}