package com.mert.malkinfo.profilo.ayarlar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.mert.malkinfo.profilo.Menuler.AyarlarActivity
import com.mert.malkinfo.profilo.databinding.ActivityBilgilerDegisBinding

class BilgilerDegisActivity : AppCompatActivity() {
    lateinit var binding: ActivityBilgilerDegisBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBilgilerDegisBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()
        setContentView(binding.root)
        binding.btnBilgileriDegis.setOnClickListener {
                changePassword()
        }
        }
    private fun changePassword() {
        val onayla = binding.txtSuAnkiSifre.text.toString()
        val yenisifre = binding.txtDegisParola.text.toString()
        val yenisifreonayla = binding.txtDegisParolaDogrulama.text.toString()

        if (onayla.isNotEmpty() &&
            yenisifre.isNotEmpty() &&
            yenisifreonayla.isNotEmpty()
        ) {

            if (yenisifre.equals(yenisifreonayla)) {

                val user = auth.currentUser //authenticationdaki verileri user değişkenine atadık

                if (user != null && user.email != null) {

                    val credential = EmailAuthProvider // email auth provider clasını bir değişkene atadık
                        .getCredential(user.email!!, onayla)
                    user?.reauthenticate(credential)
                        ?.addOnCompleteListener {

                            if (it.isSuccessful) {
                                user?.updatePassword(yenisifre)
                                    ?.addOnCompleteListener { task ->

                                        if (task.isSuccessful) {
                                            Toast.makeText(this, "Şifreniz Başrıyla Değiştirildi.", Toast.LENGTH_SHORT).show()
                                            auth.signOut()
                                            startActivity(Intent(this, AyarlarActivity::class.java))
                                            finish()
                                        }
                                    }
                            }
                            else {
                                    Toast.makeText(this, "Şifrenizi Yanlış Girdiniz", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
                else {
                    startActivity(Intent(this, AyarlarActivity::class.java))
                    finish()
                }
            }
            else {
                Toast.makeText(this, "Parolarınız Eşleşmedi Lütfen Doğrularken Emin Olun.", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this, "Lütfen Boş Alan Bırakmayınız", Toast.LENGTH_SHORT).show()
        }
    }
}