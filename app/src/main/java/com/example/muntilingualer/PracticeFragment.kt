package com.example.muntilingualer

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment



class PracticeFragment : Fragment() {
    lateinit var layout: LinearLayout
    lateinit var constant: Constant
    lateinit var toLang: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        constant = Constant()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.removeAllViews()
        return inflater.inflate(R.layout.fragment_practice, container, false)
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val practiceList: ArrayList<String> = if (args == null) {
            arrayListOf()
        } else {
            args.getStringArrayList(LIST)
        }

        val practiceFromLangTxt = view.findViewById<TextView>(R.id.practice_from_lang_txt)
        val practiceToLangTxt = view.findViewById<TextView>(R.id.practice_to_lang_txt)
        val practiceToLangPronunciation = view.findViewById<TextView>(R.id.practice_to_lang_pronunciation)

        practiceFromLangTxt.text = practiceList[0]
        practiceToLangTxt.text = practiceList[1]
        practiceToLangPronunciation.text = practiceList[2]

        layout = view.findViewById(R.id.practice_to_lang_layout)
        layout.visibility = View.INVISIBLE
    }

    fun showToText(){
        if (layout.visibility != View.VISIBLE){
            layout.visibility = View.VISIBLE
        } else {
            layout.visibility = View.INVISIBLE
        }
    }

    companion object {
        private const val LIST = "list"

        fun newInstance(arrayList: ArrayList<String>): PracticeFragment {
            val courseList = PracticeFragment()
            val args = Bundle()
            args.putStringArrayList(LIST, arrayList)
            courseList.arguments = args
            return courseList

        }

    }
}
