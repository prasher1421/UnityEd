package com.example.educationapp.exam_after_intermediate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.educationapp.*
import com.example.educationapp.activity.MainActivity
import com.example.educationapp.adapter.exam_after_intermediate_adapter
import com.google.gson.Gson
import java.io.IOException

class exams_after_intermediate_engg : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val gson = Gson()
        val main = MainActivity()
        val jsonString = main.getJSONFromAssets(activity!!,"ExamsAfterIntermediate.json")
        val exam_after_Intermediate_Model = gson.fromJson(
            jsonString,
            ExamAfterIntermediateListClass::class.java
        )
        val view=inflater.inflate(R.layout.fragment_exams_after_intermediate_engg, container, false)
        val entrance_list:ArrayList<ExamAfterIntermediateExamClass> =ArrayList<ExamAfterIntermediateExamClass>()
        val recyler_view_exams=view.findViewById<RecyclerView>(R.id.recycler_view_exams)
        try{
//            var i:Int=0
            for(i in 0 until exam_after_Intermediate_Model.data[0].streams[0].entrance_exams.size) {
                entrance_list.add(exam_after_Intermediate_Model.data[0].streams[0].entrance_exams[i])
            }
        }catch (ex: IOException){
            ex.printStackTrace()
        }
        recyler_view_exams.adapter= exam_after_intermediate_adapter(activity!!, entrance_list)
        recyler_view_exams.layoutManager = LinearLayoutManager(context)
        return view
    }
}