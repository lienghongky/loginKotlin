package com.tenriel.lienghongky.loginhomework

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val FILENAME = "prefs"
    var PRE: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PRE = this.getSharedPreferences(FILENAME,0)
        var isLoggedIn = PRE!!.getBoolean("ISLOGEDIN",false)
        if (isLoggedIn){
            var intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            var email = PRE!!.getString("EMAIL","X")
            var name = PRE!!.getString("NAME","X")
            var password = PRE!!.getString("PASSWORD","X")
            Log.d("Ilogin",email)
            Log.d("Ologin",txtEmail.text.toString().trim())
            if (txtEmail.text.toString().trim() == email && txtPassword.text.toString().trim() == password){
                var intent = Intent(this,ProfileActivity::class.java)
                val editor = PRE!!.edit()
                editor.putBoolean("ISLOGEDIN",true)
                editor.apply()
                startActivity(intent)
            }



        }



        btnSignUp.setOnClickListener {
            var intent = Intent(this,SignUpActivity::class.java)

            startActivity(intent)
        }
    }
}
