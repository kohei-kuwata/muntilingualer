package com.example.muntilingualer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class PracticeFragment : Fragment() {
    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        container?.removeAllViews()
        return inflater.inflate(R.layout.fragment_practice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val viewTxt = if (args == null) {
            ""
        } else {
            args.getString(TXT)
        }

        val listTextView = view.findViewById<TextView>(R.id.frgm_list_txt)
        listTextView.text = viewTxt
    }

    companion object {
        private const val TXT = "txt"

        fun newInstance(txt: String): PracticeFragment {
            val courseList = PracticeFragment()
            val args = Bundle()
            args.putString(TXT, txt)
            courseList.arguments = args
            return courseList

        }

    }
}
