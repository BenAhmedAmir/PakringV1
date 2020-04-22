package com.example.parkingv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window

class beforeLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide(); // hide the title bar
   /*     this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen*/
        setContentView(R.layout.activity_before_login)
    }

    fun cadreLogin(view: View) {
        var toLogin = Intent(this,LoginActivity::class.java)
        startActivity(toLogin)
    }

    fun signUp(view: View) {
        var ToSignUp = Intent(this,SignupActivity::class.java)
        startActivity(ToSignUp)
    }
}
