package com.miu.cvbuilderapp

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.miu.cvbuilderapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.login.*


class MainActivity : AppCompatActivity() {

    var userArr = arrayListOf(
        User("Su Lai","Zin","sulai@gmail.com","123")
        ,User("William","Smith","will@gmail.com","123")
        ,User("Rahul","Chaturvedi","rahul@gmail.com","123")
        ,User("Bill","Gates","bill@hotmail.com","123")
        ,User("Nilar","Mya","nila@123.com","123"))

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tvReq.text = ""
        btnSignIn.setOnClickListener{
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()
            if(email.equals("") || password.equals("")){
                tvReq.text = "*Required field(s)."
            }else{
                for(u in userArr){
                    if(u.username == email && u.password == password){
                        val intent = Intent(this,UserActivity::class.java)
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



}