package com.example.muntilingualer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectPracticeTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_practice_type)

        val btn: Button = findViewById(R.id.btn_word)
        val intent = Intent(this, PracticeActivity::class.java)
        btn.setOnClickListener {
            startActivity(intent)
        }
    }
}
