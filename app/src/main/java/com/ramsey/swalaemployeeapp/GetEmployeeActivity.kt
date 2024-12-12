package com.ramsey.swalaemployeeapp

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode.Callback
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONArray

class GetEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_get_employee)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // find views by id
        val progress = findViewById<ProgressBar>(R.id.prog) as ProgressBar
        // need the api helper
        val helper = ApiHelper(applicationContext)
        //access the get class
        //val api ="https://swalamodcom.pythonanywhere.com/employee"
        helper.get("http://192.168.20.12:5000/employee", object:ApiHelper.CallBack{
            override fun onSuccess(result: String?) {
                // convert the response to an array{list}
                val employees = JSONArray(result) // parse response
                //loop through list to get each employee
                (0 until employees.length()).forEach {
                    // get Employees
                    val employee = employees.getJSONObject(it)
                    //for each employee get the textview and append the employeeData

                    val abc = findViewById<TextView>(R.id.get) as TextView
                    abc.append("Id:" + employee.get("id_number") + "\n")
                    abc.append("username : " + employee.get("username") + "\n")
                    abc.append("others :" + employee.get("others") + "\n")
                    abc.append("salary :" + employee.get("others") + "\n" )
                    abc.append("department :"+ employee.get("others") + "\n" )
                    abc.append("\n")
                }
                progress.visibility = View.GONE //hide progress
            }

        })
    }
}