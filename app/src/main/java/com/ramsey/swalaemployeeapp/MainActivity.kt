package com.ramsey.swalaemployeeapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Postbutton
        val gotopost = findViewById<Button>(R.id.BtnPost) as Button
        gotopost.setOnClickListener {
            val x = Intent(applicationContext, PostEmployeeActivity::class.java)
            startActivity(x)
        }
//        Getbutton
        val gotoget = findViewById<Button>(R.id.BtnGet) as Button
        gotoget.setOnClickListener {
            val x = Intent(applicationContext, GetEmployeeActivity::class.java)
            startActivity(x)
        }
//        Update button
        val gotoupdate = findViewById<Button>(R.id.BtnUpdate) as Button
        gotoupdate.setOnClickListener {
            val x = Intent(applicationContext, UpdateEmployeeActivity::class.java)
            startActivity(x)
        }
//        Delete button
        val gotodelete = findViewById<Button>(R.id.BtnDelete) as Button
        gotodelete.setOnClickListener {
            val x = Intent(applicationContext, DeleteEmployeeActivity::class.java)
            startActivity(x)
        }
//                        post messages button
            val gotopostmessage = findViewById<Button>(R.id.Btnpostmessage) as Button
            gotopostmessage.setOnClickListener {
                val x = Intent(applicationContext, PostMessagesActivity::class.java)
                startActivity(x)



            }
        val gotogetmessage = findViewById<Button>(R.id.Btngetmessage) as Button
        gotogetmessage.setOnClickListener {
            val x = Intent(applicationContext, GetMessages::class.java)
            startActivity(x)

        }
    }
}



