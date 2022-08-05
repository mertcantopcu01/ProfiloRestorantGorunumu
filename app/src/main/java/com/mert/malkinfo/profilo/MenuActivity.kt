package com.mert.malkinfo.profilo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mert.malkinfo.profilo.UrunlerActivity
import com.mert.malkinfo.profilo.UserlistActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        getSupportActionBar()?.setTitle("PROFİLO")

        val detaylarigor = findViewById<Button>(R.id.btnFaturalar)
        detaylarigor.setOnClickListener {
            val Intent = Intent(this, UserlistActivity::class.java)
            startActivity(Intent)
        }
        val urunler = findViewById<Button>(R.id.btnUrunler)
        urunler.setOnClickListener {
            val Intent = Intent(this, UrunlerActivity::class.java)
            startActivity(Intent)
        }

    }
}
