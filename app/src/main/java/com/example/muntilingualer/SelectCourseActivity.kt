package com.example.muntilingualer

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectCourseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_course)

        val frgmManager = supportFragmentManager
        val frgmTransaction = frgmManager.beginTransaction()

        val frgm01 = CourseList.newInstance("List1")
        val frgm02 = CourseList.newInstance("List2")
        val frgm03 = CourseList.newInstance("List3")

        val frgmArray = arrayOf(frgm01, frgm02, frgm03)
        val arraySize = frgmArray.size -1
        var currentFrgm = frgm01
        var position = 0

        frgmTransaction.add(R.id.course_list, currentFrgm)
        frgmTransaction.commit()

        val btn_back = findViewById<Button>(R.id.btn_list_back)
        btn_back.setOnClickListener {
            val frgmTransaction = supportFragmentManager.beginTransaction()
            position = frgmArray.indexOf(currentFrgm)
            if (position == 0) {
            } else {
                position -= 1
            }
            currentFrgm = frgmArray[position]

            frgmTransaction.replace(R.id.course_list, currentFrgm)
            frgmTransaction.commit()
        }

        val btn_next = findViewById<Button>(R.id.btn_list_next)
        btn_next.setOnClickListener {
            val frgmTransaction = supportFragmentManager.beginTransaction()
            position = frgmArray.indexOf(currentFrgm)
            if (position == arraySize) {
            } else {
                position += 1
            }
            currentFrgm = frgmArray[position]


            frgmTransaction.replace(R.id.course_list, currentFrgm)
            frgmTransaction.commit()
        }
    }
}