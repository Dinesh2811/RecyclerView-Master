package com.dinesh.recyclerview.kotlin.diffutill


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.dinesh.recyclerview.R

class MainActivity : AppCompatActivity() {
    private val TAG = "log_" + MainActivity::class.java.name.split(MainActivity::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]
//    https://www.howtodoandroid.com/update-android-recyclerview-using-diffutil/
//    https://github.com/velmurugan-murugesan/Android-Example/tree/master/RecyclerviewDiffUtil

    lateinit var recyclerView: RecyclerView
    val users = listOf<Users>(
        Users(1, "User1", "location1", "image"),
        Users(2, "User2", "location2", "image"),
        Users(3,"User3","location3","image"),
        Users(4,"User4","location4","image"),
        Users(5,"User5","location5","image")
    )

    val userAdapter = UserAdapter(users.toMutableList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diffutill_activity_main)
        Log.i(TAG, "onCreate: ")

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.adapter = userAdapter



        val btn = findViewById<Button>(R.id.btnSortDescending)
        btn.setOnClickListener {
            val sortedList  = users.sortedByDescending { it.id }
            userAdapter.setUserList(sortedList)
        }
        val btnAscending = findViewById<Button>(R.id.btnAscending)
        btnAscending.setOnClickListener {
            val sortedList  = users.sortedBy { it.id }
            userAdapter.setUserList(sortedList)
        }

    }
}