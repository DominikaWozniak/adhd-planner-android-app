package com.thesis.adhdplannerandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.thesis.adhdplannerandroidapp.db.DbManager
import com.thesis.adhdplannerandroidapp.model.User
import com.thesis.adhdplannerandroidapp.service.UserValidationService

class MainActivity : AppCompatActivity() {

    lateinit var signUp: Button
    lateinit var signIn: Button
    lateinit var rePassword: TextView
    lateinit var dataBase: DbManager
    lateinit var validator: UserValidationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signUp = findViewById(R.id.signup)
        signIn = findViewById(R.id.signin)
        dataBase = DbManager(this)
        rePassword = findViewById(R.id.repassword)

        val user = User()
        returnUserObject(user)

        signUp.setOnClickListener {
        val intent = Intent()
            val rePass: String = rePassword.toString()
            validator.validateUserData(user, rePass, dataBase, this)
        }
    }

    private fun returnUserObject(user: User): User {
        val userName: TextView = findViewById(R.id.username)
        val userPassword: TextView = findViewById(R.id.password)
        val userEmail: TextView = findViewById(R.id.email)
        val userPhone: TextView = findViewById(R.id.phonenumber)

        user.name = userName.toString()
        user.password = userPassword.toString()
        user.email = userEmail.toString()
        user.phoneNumber = userPhone.toString()

        return user
    }

}