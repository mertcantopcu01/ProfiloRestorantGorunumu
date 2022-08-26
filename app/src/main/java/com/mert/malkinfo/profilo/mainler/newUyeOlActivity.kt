package com.mert.malkinfo.profilo.mainler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.mert.malkinfo.profilo.databinding.ActivityNewUyeOlBinding

class newUyeOlActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityNewUyeOlBinding
    private lateinit var firebaseAuth: FirebaseAuth //Firebasedeki Authentication kısmını aktive ettik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewUyeOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnGiriseDon.setOnClickListener {
            val intent = Intent(this, GirisActivity::class.java)
            startActivity(intent)
        }
        binding.btnKayitOl.setOnClickListener {
            val email = binding.kayitMail.text.toString()
            val pass = binding.kayitParola.text.toString()
            val confirmPass = binding.kayitParolaDogrulama.text.toString()

            binding.kayitParola.text.clear()
            binding.kayitParolaDogrulama.text.clear()
            binding.kayitMail.text.clear()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, GirisActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this, "Kayıt Oldunuz", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}