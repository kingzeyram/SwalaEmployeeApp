package com.ramsey.swalaemployeeapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONArray

class GetMessages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_get_messages)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // find views by id
        val progress = findViewById<ProgressBar>(R.id.progmessage) as ProgressBar
        // need the api helper
        val helper = ApiHelper(applicationContext)
        //access the get class
        val api ="https://modcom.pythonanywhere.com/posts"
        helper.get(api, object:ApiHelper.CallBack{
            override fun onSuccess(result: String?) {
                // convert the response to an array{list}
                val employees = JSONArray(result) // parse response
                //loop through list to get each employee
                (0 until employees.length()).forEach {
                    // get Employees
                    val employee = employees.getJSONObject(it)
                    //for each employee get the textview and append the employeeData

                    val abc = findViewById<TextView>(R.id.getmessage) as TextView
                    abc.append("nickname:" + employee.get("nickname") + "\n")
                    abc.append("message:" + employee.get("message") + "\n")
                    abc.append("\n")
                }
                progress.visibility = View.GONE //hide progress
            }

        })
    }
}