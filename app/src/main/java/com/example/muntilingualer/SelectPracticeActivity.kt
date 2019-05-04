package com.example.muntilingualer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView as ListView1

class SelectPracticeActivity : AppCompatActivity() {
    private val practiceItemMap = HashMap<String, ArrayList<SelectPracticeItem>>()
    private lateinit var global : Global

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_practice)

        global = this.application as Global
        loadPracticeItem()

        val lv = findViewById<ListView1>(R.id.lView_practice_list)
        val practiceArrayList = getPracticeItem("set")
        val selectPracticeAdapter = SelectPracticeAdapter(practiceArrayList, this)
        lv.adapter = selectPracticeAdapter

        lv.onItemClickListener = AdapterView.OnItemClickListener(function = { _, _, i, _ ->
            global.gPracticeId = (i + 1).toString().padStart(5, '0')

            val intent = Intent(this, PracticeActivity::class.java)
            intent.putExtra("CourseTitle", practiceArrayList[i].title)
            startActivity(intent)
        })
    }

    private fun getPracticeItem(courseName: String): ArrayList<SelectPracticeItem>{
        val titleName = practiceItemMap[courseName]
        if (titleName != null) {
            return titleName
        } else {
            return ArrayList()
        }
    }

    private fun loadPracticeItem() {
        addPracticeItem(practiceItemMap)
    }

    private fun addPracticeItem(practiceItem: MutableMap<String, ArrayList<SelectPracticeItem>>){
        val practiceItemList = ArrayList<SelectPracticeItem>()

        var targetCourseFile = "COURSE_LIST_WORD"
        if (global.gCourseId === "02") {
            targetCourseFile = "COURSE_LIST_CONVERSATION"
        }

        val csv = CsvReader()
        val practiceItemListData: MutableMap<String, MutableMap<String, String>> = csv.readCourseList(applicationContext, targetCourseFile)

        var selectPracticeItem: SelectPracticeItem

        practiceItemListData.forEach { (t, u) ->
            Log.d("forEach", t)
            Log.d("forEach", u.toString())
            selectPracticeItem = SelectPracticeItem()
            selectPracticeItem.number = t.toInt()
            selectPracticeItem.title = u[global.gFromLang]
            practiceItemList.add(selectPracticeItem)
        }

        practiceItem["set"] = practiceItemList
    }
}