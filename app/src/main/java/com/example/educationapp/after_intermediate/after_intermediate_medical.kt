package com.example.educationapp.after_intermediate

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.educationapp.AfterIntermediateListClass
import com.example.educationapp.adapter.Course_Type_Adapter
import com.example.educationapp.activity.MainActivity
import com.example.educationapp.R
import com.google.gson.Gson
import java.io.IOException

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var listadapter: Course_Type_Adapter

class after_intermediate_medical : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_after_intermediate_medical, container, false)

        val gson = Gson()
        val main = MainActivity()
        val jsonString = main.getJSONFromAssets(activity!!,"AfterIntermediate.json")
        val after_Intermediate_Model = gson.fromJson(
            jsonString,
            AfterIntermediateListClass::class.java
        )

        val degree_name:ArrayList<String> =ArrayList<String>()
        val deg_cour_map:HashMap<String,ArrayList<String>> = HashMap()

        try{
//            var i:Int=0
            for(i in 0 until after_Intermediate_Model.data[0].streams[1].course.size) {
                degree_name.add(after_Intermediate_Model.data[0].streams[1].course[i].degree_name +
                        "  " + after_Intermediate_Model.data[0].streams[1].course[i].course_duration)
                val sub_course:ArrayList<String> = after_Intermediate_Model.data[0].streams[1].course[i].sub_course
                deg_cour_map[degree_name[i]]=sub_course
            }

        }catch (ex: IOException){
            ex.printStackTrace()
        }

        listadapter = Course_Type_Adapter(activity!!,degree_name,deg_cour_map)

//        view.findViewById<TextView>(R.id.duration).text="Duration: "+after_Intermediate_Model.data[0].streams[1].duration
        view.findViewById<TextView>(R.id.eligibility).text=" "+after_Intermediate_Model.data[0].streams[1].eligible

        view.findViewById<ExpandableListView>(R.id.elist_Int_Medical).setAdapter(listadapter)

        val eligible_linear= view.findViewById<LinearLayout>(R.id.eligiblity_linear)

        if (after_Intermediate_Model.data[0].streams[1].eligible.length==0){
            eligible_linear.setVisibility(View.GONE)
        }

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            after_intermediate_medical().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}