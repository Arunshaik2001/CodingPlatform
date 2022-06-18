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
import com.example.codingplatform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , ProblemItemListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.app_name)

        val problemList = binding.problemsList
        val mode = binding.mode
        mode.text = getString(R.string.app_title)
        val list = listOf(
            Problem(1, "Two Sum", false),
            Problem(2, "Maximum Sub Array", false),
            Problem(3, "Reverse Words", false),
            Problem(4, "Min Stack", false),
            Problem(5, "Edit Distance", false),
            Problem(6, "Reverse Integer", false),
            Problem(7, "Count and Say", false),
            Problem(8, "Trapping Rain Water", false),
            Problem(9, "Wildcard Matching", false),
        )
        problemList.adapter = ProblemsAdapter(list,this)
        problemList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    override fun onItemClicked(item: Problem) {
        Toast.makeText(this, "${item.problemNumber} : ${item.problemName}", Toast.LENGTH_LONG).show()
    }
}