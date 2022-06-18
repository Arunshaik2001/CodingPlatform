package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codingplatform.Problem
import com.example.codingplatform.ProblemItemListener
import com.example.codingplatform.ProblemsAdapter
import com.example.codingplatform.R

class MainActivity : AppCompatActivity(), ProblemItemListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.app_name)

        val problemList = findViewById<RecyclerView>(R.id.problemsList)
        val mode = findViewById<TextView>(R.id.mode)
        mode.text = getString(R.string.app_title)
        val list = listOf(
            Problem(1, "Two Sum", false),
            Problem(2, "Three Sum", true),
            Problem(3, "Four Sum", false),
            Problem(4, "Reverse array", false),
            Problem(5, "Reverse a LinkedList", true),
            Problem(6, "Reverse array", false),
            Problem(7, "Multiply Strings", true),
            Problem(8, "Group Anagrams", false),
            Problem(9, "Pow(x,n)", true),
        )
        problemList.adapter = ProblemsAdapter(list, this)
        problemList.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClicked(item: Problem) {
        if (item.isLocked) {
            Toast.makeText(this, "Problem Locked Try in Premium mode", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "${item.problemNumber} : ${item.problemName}", Toast.LENGTH_LONG)
                .show()
        }
    }
}