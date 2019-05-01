package com.example.muntilingualer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectPracticeTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_practice_type)

        val global = this.application as Global
        val btn: Button = findViewById(R.id.btn_word)
        val intent = Intent(this, SelectCourseActivity::class.java)
        btn.setOnClickListener {
            global.practiceId = "01"
            startActivity(intent)
        }
    }
}
