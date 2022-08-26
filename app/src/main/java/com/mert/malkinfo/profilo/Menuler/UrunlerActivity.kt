package com.mert.malkinfo.profilo.Menuler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mert.malkinfo.profilo.R
import com.mert.malkinfo.profilo.databinding.ActivityMainBinding
import com.mert.malkinfo.profilo.urunler.IcecekFragment
import com.mert.malkinfo.profilo.urunler.YemekFragment

class UrunlerActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(YemekFragment())

      binding.btnIcecek.setOnClickListener{

            replaceFragment(IcecekFragment())

        }
        binding.btnYiyecek.setOnClickListener{

            replaceFragment(YemekFragment())

        }
    }

    private fun replaceFragment(fragment : Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }

}