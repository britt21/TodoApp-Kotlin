package com.example.advancetodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_todo_splash.*

class TodoSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_splash)


        Todo_text.animate().alpha(1f).setDuration(1500).withEndAction {

            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

                finish()
        }
    }
}