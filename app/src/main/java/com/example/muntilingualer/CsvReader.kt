package com.example.muntilingualer

import android.content.Context
import android.util.Log
import java.io.IOException
import java.util.ArrayList

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class CsvReader {
    private var csvList = ArrayList<CsvData>()

    fun readLangualgeList(context: Context): List<String> {
        var langList: List<String> = ArrayList<String>()
        try {
            langList = context.assets.list("LANG").toList()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return langList
    }

    fun readLessonCsv(context: Context){
        try {
            context.assets.open("LANG/JP/JP-01-00001").reader(charset=Charsets.UTF_8).forEachLine {
                Log.v("csv Log", it)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}