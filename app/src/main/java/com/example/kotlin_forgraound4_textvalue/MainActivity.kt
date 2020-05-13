package com.example.kotlin_forgraound4_textvalue

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.provider.SyncStateContract
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener(View.OnClickListener {
            val input = edit_text_input.getText().toString()
            val serviceIntent = Intent(this, ForegroundService::class.java)
            serviceIntent.putExtra("inputExtra", input)

            ContextCompat.startForegroundService(this, serviceIntent)
            serviceIntent.putExtra("inputExtra", input)
        })
        buttonStop.setOnClickListener(View.OnClickListener {
            ForegroundService.stopService(this)
        })
    }
}