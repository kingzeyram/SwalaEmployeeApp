package com.ramsey.swalaemployeeapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject

class PostMessagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_post_messages)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        find views by id
        val nickname =findViewById<EditText>(R.id.nickname) as EditText
        val message =findViewById<EditText>(R.id.message) as EditText

//        listen to clicks
        val sv =findViewById<Button>(R.id.save) as Button
        sv.setOnClickListener {
//            create JSON object
            val body = JSONObject()
//            update obj
            body.put("nickname",nickname.text.toString())
            body.put("message",message.text.toString())


//           call helper
            val api ="http://modcom.pythonanywhere.com/posts"

            val helper = ApiHelper(applicationContext)
            helper.post(api, body)
        }



    }
}