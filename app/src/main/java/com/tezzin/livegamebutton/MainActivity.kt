package com.tezzin.livegamebutton

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_button?.setOnClickListener {
            Toast.makeText(this, "CLICKED", Toast.LENGTH_SHORT).show()
        }
    }
}
