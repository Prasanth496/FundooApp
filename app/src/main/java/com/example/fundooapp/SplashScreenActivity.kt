package com.example.fundooapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val background = object : Thread(){
            override fun run(){
                try {
                    Thread.sleep(3000)
                    val intent = Intent(baseContext,LoginActivity::class.java)
                    startActivity(intent)
                }
                catch(e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
