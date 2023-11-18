package com.example.foodapp2

import Adapter.MyAdapter
import MySharedPreference
import Utils.MyData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foodapp2.databinding.ActivityListFoodBinding

class ListFoodActivity : AppCompatActivity() {
    lateinit var binding: ActivityListFoodBinding
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title="Barcha taomlar"

        MySharedPreference.init(this)
        val list = MySharedPreference.obektString
        myAdapter = MyAdapter(this, list)
      binding.listFood.adapter = myAdapter
        binding.listFood.setOnItemClickListener { parent, view, position, id ->
           val intent = Intent(this, AboutFoodActivity::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }

    }
}