package com.example.muntilingualer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.beardedhen.androidbootstrap.BootstrapButton

@Suppress("NAME_SHADOWING")
class PracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

        val intent = intent
        val title = intent.getStringExtra("CourseTitle")
        val textView = findViewById<TextView>(R.id.txView_practice)
        textView.text = title

        val frgmArray = readPracticeData()
        val arraySize = frgmArray.size -1
        var currentFrgm = frgmArray[0]
        var position: Int

        val frgmManager = supportFragmentManager
        val frgmTransaction = frgmManager.beginTransaction()
        frgmTransaction.add(R.id.view_practice, frgmArray[0])
        frgmTransaction.commit()

        val btnAnswer = findViewById<BootstrapButton>(R.id.btn_answer)
        position = frgmArray.indexOf(currentFrgm)
        btnAnswer.setOnClickListener {
            frgmArray[position].showToText()
        }

        val btnBack = findViewById<BootstrapButton>(R.id.btn_list_back)
        btnBack.setOnClickListener {
            val frgmTransaction = supportFragmentManager.beginTransaction()
            position = frgmArray.indexOf(currentFrgm)
            if (position == 0) {
            } else {
                position -= 1
            }
            currentFrgm = frgmArray[position]

            frgmTransaction.run {
                replace(R.id.view_practice, currentFrgm)
                commit()
            }
        }

        val btnNext = findViewById<BootstrapButton>(R.id.btn_list_next)
        btnNext.setOnClickListener {
            val frgmTransaction = supportFragmentManager.beginTransaction()
            position = frgmArray.indexOf(currentFrgm)
            if (position == arraySize) {
            } else {
                position += 1
            }
            currentFrgm = frgmArray[position]

            frgmTransaction.run {
                replace(R.id.view_practice, currentFrgm)
                commit()
            }
        }
    }

    @SuppressLint("NewApi")
    fun readPracticeData(): MutableList<PracticeFragment> {
        val global = this.application as Global

        val practiceFileId = "-" + global.gCourseId + "-" + global.gPracticeId + ".csv"
        val fromPracticeFile = "LANG/" + global.gFromLang + "/" + global.gFromLang + practiceFileId
        val toPracticeFile   = "LANG/" + global.gToLang   + "/" + global.gToLang   + practiceFileId
        Log.d("from", fromPracticeFile)
        Log.d("to", toPracticeFile)

        val practiceFragmentArray = mutableListOf<PracticeFragment>()
        var practiceArrayList: ArrayList<String>
        var fragment: PracticeFragment
        val csv = CsvReader()
        val fromPracticeCSV = csv.readPracticeCsv(this, fromPracticeFile)
        val toPracticeCSV = csv.readPracticeCsv(this, toPracticeFile)
        Log.d("fromCSV", fromPracticeCSV.toString())
        Log.d("toCSV", toPracticeCSV.toString())

        fromPracticeCSV.forEach { (t, u) ->
            practiceArrayList = arrayListOf()
            practiceArrayList.add(u["word"].toString())

            val constant = Constant()
            if (constant.FLAG_LANGUAGES.contains(global.gToLang)){
                practiceArrayList.add(toPracticeCSV[t]!!["pronunciation"].toString())
                practiceArrayList.add("")
            } else {
                practiceArrayList.add(toPracticeCSV[t]!!["word"].toString())
                practiceArrayList.add(toPracticeCSV[t]!!["pronunciation"].toString())
            }

            fragment = PracticeFragment.newInstance(practiceArrayList)
            practiceFragmentArray.add(fragment)
        }

        return practiceFragmentArray
    }
}