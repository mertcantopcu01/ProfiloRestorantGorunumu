package com.mert.malkinfo.profilo.mainler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mert.malkinfo.profilo.R

class SplashScreenActivity : AppCompatActivity() {
    lateinit var handler : Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler()
        handler.postDelayed({

            val intent = Intent(this, GirisActivity::class.java)
            startActivity(intent)
            finish()

        },       3000) // Delay kısmı
    }
}