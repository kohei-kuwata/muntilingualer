package com.example.muntilingualer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn_start)
        val intent = Intent(this, SelectPracticeTypeActivity::class.java)
        btn.setOnClickListener {
            startActivity(intent)
        }
    }
}

