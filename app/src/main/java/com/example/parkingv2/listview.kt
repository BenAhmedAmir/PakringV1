package com.example.parkingv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_listview.*

class listview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        add_new_note.setOnClickListener {
            val alertBuilder = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.add_note, null)
            alertBuilder.setView(view)
            val alertDialog = alertBuilder.create()
            alertDialog.show()
        }
    }
}
