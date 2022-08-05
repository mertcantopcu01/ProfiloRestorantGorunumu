package com.mert.malkinfo.profilo

import com.mert.malkinfo.profilo.User

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.widget.Button
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

import java.text.FieldPosition

class UserlistActivity : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<User>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist)
        getSupportActionBar()?.setTitle("PROFİLO")




        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<User>()

        getUserData()

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
                adapter.setOnItemClickListener(object :MyAdapter.onItemClickListener{
                    override fun onItemClick(position: Int) {
                        // Toast.makeText(this@UserlistActivity,"You clicked me $position",Toast.LENGTH_SHORT).show()

                        val intent = Intent(this@UserlistActivity,hoho::class.java)

                        startActivity(intent)
                    }


                })



            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }




}