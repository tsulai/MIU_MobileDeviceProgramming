package com.miu.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var foodList = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
        tvFoodName.text = foodList[(0..4).random()]
        btnDecide.setOnClickListener{
            tvFoodName.text = foodList[(0..4).random()]
        }
        btnAddFood.setOnClickListener{
            if(etAddNewFood.text.toString()!== "add new food"){
                foodList.add(etAddNewFood.text.toString())
                println(foodList.toString())
            }
        }
    }
}