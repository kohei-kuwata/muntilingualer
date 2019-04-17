package com.example.muntilingualer

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import java.io.File
import java.io.IOException
import java.util.ArrayList

class CsvReader {
    private var csvList = ArrayList<CsvData>()

    fun reader(context: Context){
        try {
            context.assets.open("JP/JP-01-00001").reader(charset=Charsets.UTF_8).forEachLine {
                Log.v("csv Log", it)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}