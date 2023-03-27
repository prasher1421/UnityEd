package com.example.educationapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.educationapp.R
import com.example.educationapp.exams

class after10th_poly_adapter (val context: Context, val exam_list: ArrayList<exams>) :  //passing exam_list object
    RecyclerView.Adapter<after10th_poly_adapter.ViewHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.after10th_poly_child, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=exam_list[position]
        holder.text_exam_name.text=item.exam_name
        holder.text_website.text=item.website
    }

    override fun getItemCount(): Int {
        return exam_list.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){ //viewholder class
        val text_exam_name=view.findViewById<TextView>(R.id.text_exam_name)  //initialising values
        val text_website=view.findViewById<TextView>(R.id.text_website)

    }
}