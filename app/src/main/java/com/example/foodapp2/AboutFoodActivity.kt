package com.example.foodapp2

import MySharedPreference
import Utils.MyData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodapp2.databinding.ActivityAboutFoodBinding

class AboutFoodActivity : AppCompatActivity() {
    lateinit var binding: ActivityAboutFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        MySharedPreference.init(this)
        val list = MySharedPreference.obektString
        val position = intent.getIntExtra("position", 0)
        binding.txtName.text = list[position].name
        binding.txtFoodProducts.text = list[position].ingredient
        binding.txtPreparationOrder.text = list[position].preparationOrder
    }
}