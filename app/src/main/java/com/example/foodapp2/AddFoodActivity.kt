package com.example.foodapp2

import MySharedPreference
import Utils.MyData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foodapp2.databinding.ActivityAddFoodBinding
import models.Food

class AddFoodActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddFoodBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Taom qo'shish"
        MySharedPreference.init(this)

        binding.btnSave.setOnClickListener {
            
            val name = binding.edtFoodName.text.toString().trim()
            val products = binding.edtFoodProducts.text.toString().trim()
            val preparationOrder = binding.edtPreparationOrder.text.toString().trim()

            if (name!="" && products!="" && preparationOrder!=""){
                val list = MySharedPreference.obektString
                list.add(Food(name, products, preparationOrder))
                MySharedPreference.obektString = list
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this, "Ma'lumot yetarli emas", Toast.LENGTH_SHORT).show()
            }
        }


    }
}