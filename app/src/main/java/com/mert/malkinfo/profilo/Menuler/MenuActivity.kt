package com.mert.malkinfo.profilo.Menuler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.mert.malkinfo.profilo.R
import com.mert.malkinfo.profilo.faturalar.UserlistActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

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

        val ayarlar = findViewById<ImageButton>(R.id.btnSettings)
        ayarlar.setOnClickListener {
            val Intent = Intent(this, AyarlarActivity::class.java)
            startActivity(Intent)
        }


    }
}
