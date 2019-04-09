package com.example.muntilingualer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SelectCourseActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_course)

        val courseListFragment = courseListFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.view_select_course, courseListFragment)
        transaction.commit()
    }
}