package com.example.educationapp.after10th

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.educationapp.*
import com.example.educationapp.activity.MainActivity
import com.example.educationapp.after_intermediate.listadapter
import com.example.educationapp.adapter.Course_Type_Adapter
import com.example.educationapp.adapter.after10th_poly_adapter
import com.google.gson.Gson
import java.io.IOException

class after_10th_polytechnic : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val gson = Gson()
        val main = MainActivity()
        val jsonString = main.getJSONFromAssets(activity!!,"After10th.json")
        val after_10th_Model = gson.fromJson(
            jsonString,
            AfterTenListClass::class.java
        )
        // Inflate the layout for this fragment

        val view= inflater.inflate(R.layout.fragment_after_10th_polytechnic, container, false)
        val course_name:ArrayList<String> =ArrayList<String>()
        val course_map:HashMap<String,ArrayList<String>> = HashMap()

        try{
//            var i:Int=0
            for(i in 0 until after_10th_Model.data[0].streams[1].course.size) {
                course_name.add(after_10th_Model.data[0].streams[1].course[i].name)
                val sub_course:ArrayList<String> = after_10th_Model.data[0].streams[1].course[i].sub_course
                course_map[course_name[i]]=sub_course
            }
        }catch (ex: IOException){
            ex.printStackTrace()
        }
        val text_int=view.findViewById<TextView>(R.id.text_after10th)
        text_int.text=after_10th_Model.data[0].streams[1].duration
//        val text_exam_name=view.findViewById<TextView>(R.id.text_exam_name)
//        val text_website=view.findViewById<TextView>(R.id.Text_website)

//        text_exam_name.text=after_10th_Model.data[0].streams[1].examination[0].exam_name

        listadapter = Course_Type_Adapter(activity!!, course_name, course_map)
        view.findViewById<ExpandableListView>(R.id.elist_10th_poly).setAdapter(listadapter)

        var exam_list:ArrayList<exams> = ArrayList<exams>()

        for(i in 0 until after_10th_Model.data[0].streams[1].examination.size){
            exam_list.add(after_10th_Model.data[0].streams[1].examination[i])
        }
        val recycler_view_polytechnic=view.findViewById<RecyclerView>(R.id.recycler_view_polytechnic)

        recycler_view_polytechnic.adapter= after10th_poly_adapter(activity!!, exam_list)
        recycler_view_polytechnic.layoutManager= LinearLayoutManager(context)

        val duration_view=view.findViewById<LinearLayout>(R.id.duration_linear_after10th)
        if(after_10th_Model.data[0].streams[1].duration.length==0){
            duration_view.setVisibility(View.GONE)   //Removing view if text is empty
        }

        return view
    }

}