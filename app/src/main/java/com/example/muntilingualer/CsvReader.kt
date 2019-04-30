package com.example.muntilingualer

import android.content.Context
import android.util.Log
import java.io.IOException
import java.util.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class CsvReader {
    fun readLanguageFolder(context: Context): List<String> {
        var langFolders: List<String> = ArrayList()
        try {
            langFolders = context.assets.list("LANG").toList()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return langFolders
    }

    fun readLanguageList(context: Context): MutableMap<String, String> {
        val langList: MutableMap<String, String> = mutableMapOf()
        try {
            context.assets.open("LANG_LIST").reader(charset=Charsets.UTF_8).forEachLine {
                val lineArray = it.split(",")
                langList[lineArray[0]] = lineArray[1]
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return langList
    }

    fun readCourseList(context: Context, fileName: String): MutableMap<String, MutableMap<String, String>> {
        val courseList: MutableMap<String, MutableMap<String, String>> = mutableMapOf()
        var courseMap: MutableMap<String, String>
        var loopFirstFlag = true
        var start = 0
        var end  = 0
        var langArray:List<String> = mutableListOf()
        try {
            context.assets.open(fileName).reader(charset=Charsets.UTF_8).forEachLine {
                val lineArray = it.split(",")

                if (loopFirstFlag) {
                    langArray = lineArray
                    start = 1
                    end = lineArray.size - 1

                    loopFirstFlag = false
                } else {
                    courseMap = mutableMapOf()
                    (start..end).forEach { i ->
                        courseMap[langArray[i]] = lineArray[i]
                        courseList[lineArray[0]] = courseMap
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        Log.d("courseList", courseList.toString())
        return courseList
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