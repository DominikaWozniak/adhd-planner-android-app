package com.thesis.adhdplannerandroidapp.service

import android.text.TextUtils
import android.widget.Toast
import com.thesis.adhdplannerandroidapp.MainActivity
import com.thesis.adhdplannerandroidapp.db.DbManager
import com.thesis.adhdplannerandroidapp.model.User

class UserValidationService{

    fun validateUserData(user: User, rePass: String, db: DbManager, mainActivity: MainActivity) {
        if (TextUtils.isEmpty(user.name) ||
            TextUtils.isEmpty(user.password) ||
            TextUtils.isEmpty(rePass)) {
            Toast.makeText(mainActivity,
                "All fields are required", Toast.LENGTH_SHORT).show()
        } else {
            if(rePass == user.password) {
                val checkUser: Boolean = db.checkUsername(user.name)
                if (!checkUser) {
                    val insert: Boolean = db.addNewUser(
                        user.name, user.email, user.password, user.phoneNumber)
                    if (insert) {
                        Toast.makeText(mainActivity,
                            "Registered Successfully!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}