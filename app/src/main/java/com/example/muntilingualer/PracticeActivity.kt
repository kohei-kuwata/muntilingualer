package com.example.muntilingualer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("NAME_SHADOWING")
class PracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)

        val intent = intent
        val title = intent.getStringExtra("CourseTitle")

        val textView = findViewById<TextView>(R.id.txView_practice)
        textView.text = title

        val frgmManager = supportFragmentManager
        val frgmTransaction = frgmManager.beginTransaction()

        val frgm01 = PracticeFragment.newInstance("List1")
        val frgm02 = PracticeFragment.newInstance("List2")
        val frgm03 = PracticeFragment.newInstance("List3")

        val frgmArray = arrayOf(frgm01, frgm02, frgm03)
        val arraySize = frgmArray.size -1
        var currentFrgm = frgm01
        var position: Int

        frgmTransaction.add(R.id.view_practice, currentFrgm)
        frgmTransaction.commit()

        val btnBack = findViewById<Button>(R.id.btn_list_back)
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

        val btnNext = findViewById<Button>(R.id.btn_list_next)
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
}