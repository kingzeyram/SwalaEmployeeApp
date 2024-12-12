package com.ramsey.swalaemployeeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class PostEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_post_employee)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Find views by id
        val id_number = findViewById<EditText>(R.id.idnumber) as EditText
        val username = findViewById<EditText>(R.id.username) as EditText
        val others = findViewById<EditText>(R.id.others) as EditText
        val salary = findViewById<EditText>(R.id.salary) as EditText
        val department = findViewById<EditText>(R.id.department) as EditText


        //post
        val postbtn = findViewById<Button>(R.id.btnPost) as Button
        postbtn.setOnClickListener {


            val Body = JSONObject()
            //Update with json -key value

            Body.put("department", id_number.text.toString())
            Body.put("username", username.text.toString())
            Body.put("others", others.text.toString())
            Body.put("salary", salary.text.toString())
            Body.put("id_number", department.text.toString())
            //call helper
            val api = "https://swalamodcom.pythonanywhere.com/employee"

            val helper = ApiHelper(applicationContext)
            helper.post(api, Body)
        }
    }



}
