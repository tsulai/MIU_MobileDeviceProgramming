package com.miu.walmartlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        //get username
        var sintent = intent
        tvUsername.text = sintent.getStringExtra("username")
    }
    fun btnClick(view: View){
        var cat = ""
        when(view.id){
            R.id.btnClothing -> cat = "Clothing"
            R.id.btnBeauty -> cat = "Beauty"
            R.id.btnFood -> cat = "Food"
            R.id.btnElectronics -> {
                val intent = Intent(this,CategoryListActivity::class.java)
                startActivity(intent)
                cat = "Electronics"
            }
        }
        Toast.makeText(this,"You have chosen the $cat category of shopping",Toast.LENGTH_LONG).show()
    }
}