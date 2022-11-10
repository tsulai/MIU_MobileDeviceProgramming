package com.miu.walmartlogin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var userArr = arrayListOf(
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
        //Task5
        var resultContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            //callback to retrieve the result
            //result object contains the intent and RESULT_OK or RESULT_CANCEL
                result -> //what will do after getting result back
            if(result.resultCode == Activity.RESULT_OK) {
                val temp = result.data?.getSerializableExtra("user")
                val newUser = temp as User
                userArr.add(newUser)
               //println("========User Array: ${userArr.toString()}")
            }
            else{
                Toast.makeText(this,"Fail to get Result!",Toast.LENGTH_LONG).show()
            }
        }

        btnCreate.setOnClickListener{
            val intent = Intent(this,CreateAccount::class.java)
            resultContracts.launch(intent)
        }
        //task 6
        tvForgetPassword.setOnClickListener{
            var email = etEmail.text.toString()
            var pw : String? = ""
            for(u in userArr){
                if(u.username == email){
                    pw = u.password
                    break
                }
            }
            if(pw != ""){
                //send email implicit intent
                val emailIntent = Intent(
                    Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", email, null
                    )
                )
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Walmart Forgot Password")
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Your password is: $pw")
                startActivity(Intent.createChooser(emailIntent, "Send email..."))

            }else{
                Toast.makeText(this,"User Not Found!",Toast.LENGTH_LONG).show()
            }
        }
    }

}