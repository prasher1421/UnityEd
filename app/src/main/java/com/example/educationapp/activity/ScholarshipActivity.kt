package com.example.educationapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.educationapp.R
import com.example.educationapp.ScholarshipListClass
import com.example.educationapp.TalentTestListClass
import com.example.educationapp.adapter.scholarships_adapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_talent_test_activity.*
import com.example.educationapp.adapter.talent_test_adapter
import kotlinx.android.synthetic.main.activity_scholarship.*
import java.io.IOException

class ScholarshipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scholarship)
        val actionBar=supportActionBar

        if (actionBar!=null){
            actionBar.title="Scholarships" //title for actionbar
        }
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        try{
            val main = MainActivity()
            val jsonString = main.getJSONFromAssets(this,"Scholarships.json")
            val gson = Gson()
            val scholarships_Model = gson.fromJson(
                jsonString,
                ScholarshipListClass::class.java
            )
            sch_List.layoutManager = LinearLayoutManager(this)
            // Adapter class is initialized and list is passed in the param.
            val itemAdapter = scholarships_adapter(this, scholarships_Model.data[0].exams)
            // adapter instance is set to the recyclerview to inflate the items.
            sch_List.adapter = itemAdapter

        }catch (ex: IOException){
            ex.printStackTrace()
        }
    }
}
