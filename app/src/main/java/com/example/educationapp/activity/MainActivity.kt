package com.example.educationapp.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
//import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import android.view.Menu
//import android.view.MenuInflater
import android.view.MenuItem
import com.example.educationapp.FirstPage
import com.example.educationapp.R
import com.example.educationapp.adapter.first_page_adapter

class MainActivity : AppCompatActivity() {
    //RecyclerView recyclerview;
//    private lateinit var listviewadapter:Course_Type_Adapter

    var gv_first_page: GridView? = null
    var title_icon: ArrayList<FirstPage> = ArrayList<FirstPage>()
    var adapter: first_page_adapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val actionBar=supportActionBar
        if(actionBar!=null){
            actionBar.title="What Next?"
        }

//        button1.setOnClickListener{
//            val intent =Intent(this,talent_test_activity::class.java)
//            startActivity(intent)
//        }
//
//        button3.setOnClickListener{
//            val intent =Intent(this,after_intermediate_activity::class.java)
//            startActivity(intent)
//        }
//        button5.setOnClickListener{
//            val intent =Intent(this,after_graduation_activity::class.java)
//            startActivity(intent)
//        }
//        button6.setOnClickListener {
//            val intent = Intent(this, Course_type_activity::class.java)
//            // start your next activity
//            startActivity(intent)
//        }

//        val button1 = findViewById<Button>(R.id.button1)
//        val button2 = findViewById<Button>(R.id.button2)
//        val button3 = findViewById<Button>(R.id.button3)
//        val button4 = findViewById<Button>(R.id.button4)
//        val button5 = findViewById<Button>(R.id.button5)

//        button1.setOnClickListener(this)
//        button2.setOnClickListener(this)
//        button3.setOnClickListener(this)
//        button4.setOnClickListener(this)
//        button5.setOnClickListener(this)

        gv_first_page= findViewById<GridView>(R.id.gv_first_page) as GridView
        addLangData()
        adapter = first_page_adapter(title_icon, this)
        gv_first_page?.adapter = adapter

//        gv_first_page.setOnItemClickListener { parent, view, position, id ->  }

//        Toast.makeText(this, "Welcome!!", Toast.LENGTH_SHORT).show()
        gv_first_page!!.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> {
                    val intent =Intent(this, talent_test_activity::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent=Intent(this, after_10th_activity::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent =Intent(this, after_intermediate_activity::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent=Intent(this, exams_after_intermediate_activity::class.java)
                    startActivity(intent)

                }
                4 -> {
                    val intent =Intent(this, after_graduation_activity::class.java)
                    startActivity(intent)
                }
                5 -> {
                    val intent = Intent(this, Course_type_activity::class.java)
                    // start your next activity
                    startActivity(intent)
                }
                6 -> {
                    val intent =Intent(this, ScholarshipActivity::class.java)
                    startActivity(intent)
                }
                7 -> {
                    gotoURL(getString(R.string.discordLink))
                }
            }
        }
    }

    private fun gotoURL(s: String) {
        val uri = Uri.parse(s)
        startActivity(Intent(Intent.ACTION_VIEW,uri))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId) {
            R.id.menu_icon -> {
                val intent = Intent(this, gallery_activity::class.java)
                startActivity(intent)
            }
        }


            return super.onOptionsItemSelected(item)
    }


     private fun addLangData() {
        val talentTest = FirstPage()
        talentTest.title = "Talent Test at Glance"
        talentTest.img_icon= R.drawable.ic_talent_test
        title_icon.add(talentTest)

        val afterTenth = FirstPage()
        afterTenth.title = "After 10th"
        afterTenth.img_icon= R.drawable.ic_after10th
        title_icon.add(afterTenth)

        val afterIntermediate = FirstPage()
        afterIntermediate.title = "After Intermediate"
        afterIntermediate.img_icon= R.drawable.ic_afterintermediate
        title_icon.add(afterIntermediate)

        val examAfterIntermediate = FirstPage()
        examAfterIntermediate.title = "Exams After Intermediate"
        examAfterIntermediate.img_icon= R.drawable.ic_exam
        title_icon.add(examAfterIntermediate)

        val afterGraduation = FirstPage()
        afterGraduation.title = "After Graduation"
        afterGraduation.img_icon= R.drawable.ic_school_black_24dp
        title_icon.add(afterGraduation)

        val courseTypes = FirstPage()
        courseTypes.title = "Course Types"
        courseTypes.img_icon= R.drawable.ic_coursetypes
        title_icon.add(courseTypes)

         val scholarships = FirstPage()
        scholarships.title = "Scholarships"
        scholarships.img_icon= R.drawable.baseline_scholarship_24
        title_icon.add(scholarships)

         val communitySupport = FirstPage()
         communitySupport.title = "Community"
         communitySupport.img_icon = R.drawable.baseline_community_24
         title_icon.add(communitySupport)
    }


    fun getJSONFromAssets(context: Context, filetitle: String): String? {
        val json: String?
        try {
            val myUsersJSONFile = context.assets.open(filetitle)
            val size = myUsersJSONFile.available()
            val buffer = ByteArray(size)
            myUsersJSONFile.read(buffer)
            myUsersJSONFile.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}


//    override fun onClick(v: View) {
//        button1.setOnClickListener(this)
//        when (v.id) {
//            R.id.button1 -> Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show()
//            R.id.button2 -> Toast.makeText(this, "Button 2 clicked", Toast.LENGTH_SHORT).show()
//            R.id.button3 -> Toast.makeText(this, "Button 3 clicked", Toast.LENGTH_SHORT).show()
//            R.id.button4 -> Toast.makeText(this, "Button 4 clicked", Toast.LENGTH_SHORT).show()
//            R.id.button5 -> Toast.makeText(this, "Button 5 clicked", Toast.LENGTH_SHORT).show()
//        }
//    }

//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//        var TitleName= ArrayList<String>()
//        var Exams= ArrayList<String>()
//        var titletitle= ArrayList<String>()
//        var test_title= ArrayList<String>()
//        var eligibility= ArrayList<String>()
//        var syllabus= ArrayList<String>()
//        var website_link= ArrayList<String>()

//        val jsonString = getJSONFromAssets(this)
        //Talent Test Page

//        val talent_Test_Model = gson.fromJson(
//            jsonString,
//            TalentTestListClass::class.java
//        )
        //Exams After Intermediate

//        val exam_after_intermediate_model = gson.fromJson(
//            jsonString,
//            ExamAfterIntermediateListClass::class.java
//        )

        //Course Type

//        var gson = Gson()
//        val Course_Type_Model = gson.fromJson(
//            getJSONFromAssets(this),
//            CourseTypeListClass::class.java
//        )

        //After Intermediate
//        val After_Intermedaite_Model = gson.fromJson(
//            getJSONFromAssets(this,"after_intermediate_activity.json"),
//            AfterIntermediateListClass::class.java)

        //After Graduation

//        val After_Graduation_Model = gson.fromJson(
//            getJSONFromAssets(this),
//            AfterGraduationListClass::class.java
//        )

        //After 10th

//        val After_Tenth_Model = gson.fromJson(
//            getJSONFromAssets(this),
//            AfterTenListClass::class.java
//        )

// Fetching Data using JSONObjects and JSONArray

//        try {
//            var i: Int = 0;
//            val obj = JSONObject(getJSONFromAssets(this))
//            val userArray = obj.getJSONArray("data")
//            for (i in  0 until userArray.length()){
//                //creating json object for fetching data
//                val userDetail = userArray.getJSONObject(i)
//                TitleName.add(userDetail.getString("title"))
//                val examarray=userDetail.getJSONArray("exams")
//                var j=0
//               for(j in 0 until examarray.length()){
//                   val examDetail = examarray.getJSONObject(j)
//                   test_title.add(examDetail.getString("test_title"))
//                   eligibility.add(examDetail.getString("eligibility"))
//                   syllabus.add(examDetail.getString("syllabus"))
//                   website_link.add(examDetail.getString("website"))
//               }
//
//            }
//        }catch (ex: IOException){
//            ex.printStackTrace()
//        }

//        recyclerView.adapter = Course_Type_Adapter(Course_Type_Model.data)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)

//        var Firstlist:ArrayList<String> = ArrayList<String>()
//        var Topiclist:HashMap<String,ArrayList<String>> = HashMap()
//        try{
//            var i:Int=0
//            for(i in 0 until Course_Type_Model.data[0].courses.size) {
//                var Slist:ArrayList<String>
//                Firstlist.add(Course_Type_Model.data[0].courses[i].title)
//                Slist=Course_Type_Model.data[0].courses[i].course_title
//                Topiclist[Firstlist[i]]=Slist
//            }
//
//
//        }catch (ex:IOException){
//            ex.printStackTrace()
//        }
//        listviewadapter= Course_Type_Adapter(this,Firstlist,Topiclist)
//        elistView.setAdapter(listviewadapter)


//        Toast.makeText(this,"Welcome!!",Toast.LENGTH_SHORT).show()
//        Log.d("Main Activity","Size:")

//    private fun showList() {
//        var gson = Gson()
//        val Course_Type_Model = gson.fromJson(
//            getJSONFromAssets(this),
//            CourseTypeListClass::class.java
//        )
//        lateinit var Flist:ArrayList<String>
//        lateinit var Topiclist:HashMap<String,ArrayList<String>>
//        var i:Int=0
//        for(i in 0 until Course_Type_Model.data[0].courses.size) {
//            var Slist:ArrayList<String>
//            Flist.add(Course_Type_Model.data[0].courses[i].title)
////            var Flist=Course_Type_Model.data[0].courses[i].title
//            Slist=Course_Type_Model.data[0].courses[i].course_title
////                (Slist as ArrayList<>)
//            Topiclist[Flist[i]]=Slist
//    }
//
//    }

