package com.ramsey.swalaemployeeapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class UpdateEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update_employee)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //findviewsbyid

        val id_number = findViewById<EditText>(R.id.putidnumber) as EditText
        val salary = findViewById<EditText>(R.id.putsalary) as EditText

        val  update = findViewById<Button>(R.id.update) as Button

        //listen to the button
        update.setOnClickListener{
            //create json obj
            val body = JSONObject()
            //update obj
             body.put("id_number", id_number.text)
             body.put("salary", salary.text)
            //call api helper
            val helper =ApiHelper(applicationContext)
            val api ="https://swalamodcom.pythonanywhere.com/employee"
            helper.put(api,body)

        }
        //put to api

    }
}