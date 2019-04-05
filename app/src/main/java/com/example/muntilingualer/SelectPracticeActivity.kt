package com.example.muntilingualer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectPracticeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_practice)

        val btn: Button = findViewById(R.id.btn_word)
        val intent = Intent(this, SelectCourseActivity::class.java)
        btn.setOnClickListener {
            startActivity(intent)
        }
    }
}
