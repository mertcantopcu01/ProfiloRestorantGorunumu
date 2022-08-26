package com.mert.malkinfo.profilo.faturalar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.mert.malkinfo.profilo.Menuler.MenuActivity
import com.mert.malkinfo.profilo.Siniflar.MyAdapter
import com.mert.malkinfo.profilo.R
import com.mert.malkinfo.profilo.Siniflar.User

class UserlistActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist)


        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.setLayoutManager(GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false))
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<User>()

        getUserData()

        val s = findViewById<ImageButton>(R.id.btnGeri)
        s.setOnClickListener {
            val Intent = Intent(this, MenuActivity::class.java)
            startActivity(Intent)
        }
    }

    private fun getUserData (){

        dbref = FirebaseDatabase.getInstance().getReference("Users")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(User::class.java)
                        userArrayList.add(user!!)
                    }
                }
                var adapter = MyAdapter(userArrayList)
                userRecyclerview.adapter =adapter
                   adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
                    override fun onItemClick(position: Int) {
                        // Veriye tıklandığında detaylarını gösterecek sayfa açılacak
                    }
                })
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}