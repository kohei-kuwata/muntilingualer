package com.example.muntilingualer

import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView as ListView1

class SelectLanguageActivity : AppCompatActivity() {
    private val courseItem = HashMap<String, ArrayList<SelectPracticeItem>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_language)

        loadCourse()

        val lv = findViewById<ListView1>(R.id.lView_select_language)
        val courses = getCourse("set")
        val courseAdapter = SelectPracticeAdapter(courses, this)
        lv.adapter = courseAdapter

        lv.onItemClickListener = AdapterView.OnItemClickListener(function = { _, _, i, _ ->

            intent.putExtra("LANG", courses[i].practiceItemId)
            setResult(intent.getIntExtra("btn_code", 0 ), intent)
            finish()
        })
    }

    private fun getCourse(courseName: String): ArrayList<SelectPracticeItem>{
        val titleName = courseItem[courseName]
        return titleName ?: ArrayList()
    }

    private fun loadCourse() {
        addCourse(courseItem)
    }

    private fun addCourse(practiceItem: MutableMap<String, ArrayList<SelectPracticeItem>>){
        val courseList = ArrayList<SelectPracticeItem>()

        val csv = CsvReader()
        val langFolders = csv.readLanguageFolder(applicationContext)
        val langList = csv.readLanguageList(applicationContext)

        var practice: SelectPracticeItem
        var count = 1
        langFolders.forEach{
            practice = SelectPracticeItem()
            practice.number = count
            practice.practiceItemId = it
            practice.title = langList[it]
            courseList.add(practice)

            count++
        }

        practiceItem["set"] = courseList
    }

}