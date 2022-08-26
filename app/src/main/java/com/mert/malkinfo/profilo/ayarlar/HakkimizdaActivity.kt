package com.mert.malkinfo.profilo.ayarlar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.mert.malkinfo.profilo.Menuler.AyarlarActivity
import com.mert.malkinfo.profilo.R

class HakkimizdaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hakkimizda)
        val s = findViewById<ImageButton>(R.id.btnGeri)
        s.setOnClickListener {
            val Intent = Intent(this, AyarlarActivity::class.java)
            startActivity(Intent)
        }
    }

}