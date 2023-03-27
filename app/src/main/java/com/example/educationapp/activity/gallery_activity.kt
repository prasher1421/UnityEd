package com.example.educationapp.activity

import android.os.Bundle
//import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.educationapp.ImagesClass
import com.example.educationapp.R
import com.example.educationapp.adapter.galleryAdapter
import com.google.gson.Gson
import java.io.IOException


class gallery_activity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var mAdapter: galleryAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)


        val actionBar=supportActionBar

        if (actionBar!=null){
            actionBar.title="Gallery" //title for actionbar
        }
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val main = MainActivity()
        val jsonString = main.getJSONFromAssets(this, "Images.json")
        val gson = Gson()
        val Gallery_Model = gson.fromJson(
            jsonString,
            ImagesClass::class.java
        )
        val college_name_list:ArrayList<String> = ArrayList<String>()
        val image_url_list:ArrayList<String> = ArrayList<String>()
        try{
//            var i:Int=0
//            for(i in 0 until Gallery_Model.data[0].gallery.size) {
//                college_name_list.add(Gallery_Model.data[0].gallery[i].college_name)
//                image_url_list.add(Gallery_Model.data[0].gallery[i].image_url)
//            }
            //Changes needs to be made

            recyclerView = findViewById(R.id.gallery_recyclerview);
            val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 2)
            mAdapter = galleryAdapter(applicationContext, Gallery_Model.data[0].gallery)
            recyclerView!!.layoutManager = layoutManager
            recyclerView!!.itemAnimator = DefaultItemAnimator()
            recyclerView!!.adapter = mAdapter

        }catch (ex: IOException){
            ex.printStackTrace()
        }
    }
}
