package com.tenriel.lienghongky.loginhomework

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    val FILENAME = "prefs"
    var PRE: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        PRE = this.getSharedPreferences(FILENAME,0)
        var email = PRE!!.getString("EMAIL","X")
        var name = PRE!!.getString("NAME","X")

        var user = User(name,email,"NULL")

        edtFullName.setText(user.name)
        edtEmail.setText(user.email)


        btnLogOut.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            val editor = PRE!!.edit()
            editor.putBoolean("ISLOGEDIN",false)
            editor.apply()
            Toast.makeText(this,"Logged out!",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }
    }
}
