package com.mert.malkinfo.profilo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.setTitle("PROFİLO")

        val detaylarigor = findViewById<Button>(R.id.login_btn)
        detaylarigor.setOnClickListener {
            val Intent = Intent(this, MenuActivity::class.java)
            startActivity(Intent)

        }

    }
}