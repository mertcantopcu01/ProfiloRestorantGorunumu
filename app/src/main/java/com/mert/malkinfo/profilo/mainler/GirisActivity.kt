package com.mert.malkinfo.profilo.mainler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.mert.malkinfo.profilo.Menuler.MenuActivity
import com.mert.malkinfo.profilo.databinding.ActivityGirisBinding

class GirisActivity : AppCompatActivity() {
    lateinit var binding: ActivityGirisBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGirisBinding.inflate(layoutInflater)
        setContentView(binding.root)
        

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnKayit.setOnClickListener {
            val intent = Intent(this, newUyeOlActivity::class.java)
            startActivity(intent)
        }

        binding.btnGiris.setOnClickListener {
            val email = binding.girisKullaniciAdi.text.toString() //email textini email değişkenine atama
            val pass = binding.girisParola.text.toString() // şifre textini pass değişkenine atama

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                //email ve şifre boş değilse

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MenuActivity::class.java)
                        startActivity(intent)

                    }
                    else {
                        Toast.makeText(this, "Yanlış Giriş Yaptınız !!", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Kullanıcı adı veya şifreniz boş olmamalı !!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
