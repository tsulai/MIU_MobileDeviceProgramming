package com.miu.walmartlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var userArr = arrayOf(
        User("Su Lai","Zin","sulai@gmail.com","123")
        ,User("William","Smith","will@gmail.com","123")
        ,User("Rahul","Chaturvedi","rahul@gmail.com","123")
        ,User("Bill","Gates","bill@hotmail.com","123")
        ,User("Nilar","Mya","nila@123.com","123"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        btnSignIn.setOnClickListener{
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()
            for(u in userArr){
                if(u.username == email && u.password == password){
                    //Toast.makeText(this,email.toString(),Toast.LENGTH_LONG).show()
                    //pass the user name to
                    val intent = Intent(this,ShoppingCategory::class.java)
                    intent.putExtra("username",email)
                    startActivity(intent)
                    break
                }else{
                    Toast.makeText(this,"Unable to login. Please try again!",Toast.LENGTH_LONG).show()
                }
            }

        }
    }

}