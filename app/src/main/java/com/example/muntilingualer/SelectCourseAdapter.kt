package com.example.muntilingualer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SelectCourseAdapter(items: ArrayList<SelectCourseItem>, ctx: Context) : ArrayAdapter<SelectCourseItem>(ctx, R.layout.layout_select_course_item, items) {
    private class CourseItemViewHolder {
        internal var number: TextView? = null
        internal var title: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: CourseItemViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.layout_select_course_item, parent, false)

            viewHolder = CourseItemViewHolder()
            viewHolder.number = view!!.findViewById(R.id.select_course_item_number) as TextView
            viewHolder.title = view.findViewById(R.id.select_course_item_title) as TextView

        } else {
            viewHolder = view.tag as CourseItemViewHolder
        }

        val course = getItem(position)
        viewHolder.number!!.text = course!!.number.toString()
        viewHolder.title!!.text = course.title

        view.tag = viewHolder

        return view
    }
}