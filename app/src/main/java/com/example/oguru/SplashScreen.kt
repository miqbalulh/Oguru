package com.example.oguru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.oguru.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val backgrond = object : Thread(){
            override fun run() {
                try {
                    java.lang.Thread.sleep(2500)

                    val intent =
                        android.content.Intent(applicationContext, LoginTentorActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }

        backgrond.start()

    }
}
