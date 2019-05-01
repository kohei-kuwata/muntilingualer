package com.example.muntilingualer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SelectPracticeAdapter(items: ArrayList<SelectPracticeItem>, ctx: Context) : ArrayAdapter<SelectPracticeItem>(ctx, R.layout.layout_select_practice_item, items) {
    private class CourseItemViewHolder {
        internal var number: TextView? = null
        internal var title: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: CourseItemViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.layout_select_practice_item, parent, false)

            viewHolder = CourseItemViewHolder()
            viewHolder.number = view!!.findViewById(R.id.select_practice_item_number) as TextView
            viewHolder.title = view.findViewById(R.id.select_practice_item_title) as TextView

        } else {
            viewHolder = view.tag as CourseItemViewHolder
        }

        val selectPracticeItem = getItem(position)
        viewHolder.number!!.text = selectPracticeItem!!.number.toString()
        viewHolder.title!!.text = selectPracticeItem.title

        view.tag = viewHolder

        return view
    }
}