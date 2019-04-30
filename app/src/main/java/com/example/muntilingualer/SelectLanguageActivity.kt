package com.example.muntilingualer

import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView as ListView1

class SelectLanguageActivity : AppCompatActivity() {
    private val courseItem = HashMap<String, ArrayList<SelectCourseItem>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_language)

        loadCourse()

        val lv = findViewById<ListView1>(R.id.lView_select_language)
        val courses = getCourse("set")
        val courseAdapter = SelectCourseAdapter(courses, this)
        lv.adapter = courseAdapter

        lv.onItemClickListener = AdapterView.OnItemClickListener(function = { _, _, i, _ ->

            intent.putExtra("LANG", courses[i].id)
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
        val langFolders = csv.readLanguageFolder(applicationContext)
        val langList = csv.readLanguageList(applicationContext)

        var course: SelectCourseItem
        var count = 1
        langFolders.forEach{
            course = SelectCourseItem()
            course.number = count
            course.id = it
            course.title = langList[it]
            courseList.add(course)

            count++
        }

        courseItem["set"] = courseList
    }

}