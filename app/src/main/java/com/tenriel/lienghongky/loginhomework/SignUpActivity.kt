package com.tenriel.lienghongky.loginhomework

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE
import android.content.Intent

import android.widget.Toast


class SignUpActivity : AppCompatActivity() {
    val FILENAME = "prefs"
    var PRE:SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        PRE = this.getSharedPreferences(FILENAME,0)


        btnSignUp.setOnClickListener {
            var user = User(edtFullName.text.toString(),edtEmail.text.toString(),edtPassword.text.toString())

            val editor = PRE!!.edit()
            editor.putString("NAME", user.name)
            editor.putString("EMAIL", user.email)
            editor.putString("PASSWORD", user.password)
            editor.apply()


            PRE = this.getSharedPreferences(FILENAME,0)
            var userSt = PRE!!.getString("NAME","default")


            var intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)

            startActivity(intent)
        }

    }
}

class User{
    var name:String?
    var email:String?
    var password:String?

    constructor(name:String,email:String,password:String){
        this.name = name
        this.email = email
        this.password = password
    }
    constructor(stringUser:String){
        if (stringUser == ""){
        this.name = ""
        this.email = ""
            this.password = ""
            return
        }
        val array = stringUser.split(",")
        this.name = array[0]
        this.email = array[1]
        this.password = array[2]
    }
    fun userToString():String{

        return this.name +","+this.email+","+this.password
    }
}
