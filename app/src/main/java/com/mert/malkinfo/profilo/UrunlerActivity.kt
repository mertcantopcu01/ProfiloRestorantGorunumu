package com.mert.malkinfo.profilo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UrunlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_urunler)
        getSupportActionBar()?.setTitle("PROFİLO")

        val sogukicecekler = findViewById<Button>(R.id.btnSogukIcecekler)
        sogukicecekler.setOnClickListener {
            val Intent = Intent(this, SogukIceceklerActivity::class.java)
            startActivity(Intent)

        }

        val yemekler = findViewById<Button>(R.id.btnYemekler)
        yemekler.setOnClickListener {
            val Intent = Intent(this, YemeklerActivity::class.java)
            startActivity(Intent)

        }

        val sıcakicecekler = findViewById<Button>(R.id.btnSıcakIcecekler)
        sıcakicecekler.setOnClickListener {
            val Intent = Intent(this, SicakIceceklerActivity::class.java)
            startActivity(Intent)

        }

        val firindan = findViewById<Button>(R.id.btnFirindan)
        firindan.setOnClickListener {
            val Intent = Intent(this, FirindanActivity::class.java)
            startActivity(Intent)

        }


    }
}