package com.mert.malkinfo.profilo.ayarlar

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.mert.malkinfo.profilo.Menuler.AyarlarActivity
import com.mert.malkinfo.profilo.R
import com.mert.malkinfo.profilo.databinding.ActivitySikayetBinding

class SikayetActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    lateinit var binding: ActivitySikayetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySikayetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)


        var kayitliMaili =("profilosikayet@profilo.com")
        binding.mailA.text =kayitliMaili.toString()

        binding.btnMail.setOnClickListener{
            binding.mailA.text = kayitliMaili
            val mail = binding.mailA.text.toString()
            val subject = binding.mailSub.text.toString()
            val message = binding.mailMes.text.toString()

            val addresses = mail.split(",".toRegex()).toTypedArray()

            val intent = Intent(Intent.ACTION_SENDTO).apply {

                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,addresses)
                putExtra(Intent.EXTRA_SUBJECT,subject)
                putExtra(Intent.EXTRA_TEXT,message)
            }
            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            }else{
                Toast.makeText(this@SikayetActivity,"App is not in your phone", Toast.LENGTH_SHORT).show()
            }
        }
        val s = findViewById<ImageButton>(R.id.btnGeri)
        s.setOnClickListener {
            val Intent = Intent(this, AyarlarActivity::class.java)
            startActivity(Intent)
        }
    }
}