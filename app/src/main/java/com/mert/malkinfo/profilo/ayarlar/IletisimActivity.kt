package com.mert.malkinfo.profilo.ayarlar

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import com.mert.malkinfo.profilo.Menuler.AyarlarActivity
import com.mert.malkinfo.profilo.R

class IletisimActivity : AppCompatActivity() {
    val phonenumber = "08502227272"
    val REQUEST_PHONE_CALL = 11

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iletisim)
        val bilgidegis = findViewById<AppCompatButton>(R.id.btnArama)
        bilgidegis.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL)
            }
            else{
                startCall()
            }

        }
        val s = findViewById<ImageButton>(R.id.btnGeri)
        s.setOnClickListener {
            val intent =  Intent(this, AyarlarActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

    }

    private fun startCall() {
        val callIntent = Intent(Intent.ACTION_CALL)

        callIntent.data = Uri.parse("tel:"+phonenumber)
        startActivity(callIntent)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}