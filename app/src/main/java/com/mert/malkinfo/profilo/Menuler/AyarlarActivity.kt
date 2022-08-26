package com.mert.malkinfo.profilo.Menuler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.mert.malkinfo.profilo.R
import com.mert.malkinfo.profilo.ayarlar.BilgilerDegisActivity
import com.mert.malkinfo.profilo.ayarlar.HakkimizdaActivity
import com.mert.malkinfo.profilo.ayarlar.IletisimActivity
import com.mert.malkinfo.profilo.ayarlar.SikayetActivity
import com.mert.malkinfo.profilo.mainler.GirisActivity

class AyarlarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayarlar)


        val cikis = findViewById<Button>(R.id.btnCikis)
        cikis.setOnClickListener {
            val intent = Intent(this, GirisActivity::class.java)
            intent.setFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        val bilgidegis = findViewById<Button>(R.id.btndegis)
        bilgidegis.setOnClickListener {
            val Intent = Intent(this, BilgilerDegisActivity::class.java)
            startActivity(Intent)
        }
        val mailss = findViewById<Button>(R.id.btnSikayet)
        mailss.setOnClickListener {
            val Intent = Intent(this, SikayetActivity::class.java)
            startActivity(Intent)
        }
        val hakkimizda= findViewById<Button>(R.id.btnHakkimizda)
        hakkimizda.setOnClickListener {
            val Intent = Intent(this, HakkimizdaActivity::class.java)
            startActivity(Intent)
        }
        val iletisim = findViewById<Button>(R.id.btnIletisim)
        iletisim.setOnClickListener {
            val Intent = Intent(this, IletisimActivity::class.java)
            startActivity(Intent)
        }
        val s = findViewById<ImageButton>(R.id.btnGeri)
        s.setOnClickListener {
            val Intent = Intent(this, MenuActivity::class.java)
            startActivity(Intent)
        }

    }
}