package com.example.muntilingualer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val CODE_REQUEST = 1
    private val CODE_FROM = 0
    private val CODE_TO = 1
    private lateinit var BTN_LANG_FROM: Button
    private lateinit var BTN_LANG_TO: Button
    private lateinit var LANG_LIST: MutableMap<String, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn_start)
        val intent = Intent(this, SelectPracticeTypeActivity::class.java)
        btn.setOnClickListener {
            startActivity(intent)
        }

        val csv = CsvReader()
        LANG_LIST = csv.readLangualgeList(applicationContext)

        val intentLang = Intent(this, SelectLanguageActivity::class.java)

        BTN_LANG_FROM = findViewById(R.id.btn_lang_from)
        BTN_LANG_FROM.text = LANG_LIST["JP"]
        BTN_LANG_FROM.setOnClickListener {
            intentLang.putExtra("btn_code", CODE_FROM)
            startActivityForResult(intentLang, CODE_REQUEST)
        }

        BTN_LANG_TO = findViewById(R.id.btn_lang_to)
        BTN_LANG_TO.text = LANG_LIST["ENUS"]
        BTN_LANG_TO.setOnClickListener {
            intentLang.putExtra("btn_code", CODE_TO)
            startActivityForResult(intentLang, CODE_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CODE_REQUEST) {
            if (resultCode == CODE_FROM) {
                BTN_LANG_FROM.text = LANG_LIST[data?.getStringExtra("LANG")]
            }else if (resultCode == CODE_TO) {
                BTN_LANG_TO.text = LANG_LIST[data?.getStringExtra("LANG")]
            }
        }
    }
}

