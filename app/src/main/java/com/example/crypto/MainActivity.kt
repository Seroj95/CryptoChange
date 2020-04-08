package com.example.crypto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.example.crypto.R.layout.activity_main

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        Thread(Runnable {
            SystemClock.sleep(2000)
            var intent = Intent(this@MainActivity, CoinPriceListActivity::class.java)

            startActivity(intent)
        }).start()

//        SystemClock.sleep(2000)
//        var intent=Intent(this@MainActivity,CoinPriceListActivity::class.java)
//
//        startActivity(intent)


    }
}
