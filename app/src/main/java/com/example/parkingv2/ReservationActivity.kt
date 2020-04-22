package com.example.parkingv2

import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ReservationActivity : AppCompatActivity() {
    private var signOut: Button? = null
    private var auth: FirebaseAuth? = null
    private var carsSpinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar()?.hide(); // hide the title bar
        setContentView(R.layout.activity_reservation)
        auth = FirebaseAuth.getInstance()
        signOut = findViewById(R.id.sign_out)
        carsSpinner = findViewById(R.id.spinnerV)
        val database = Firebase.database.reference

        var myRef = Firebase.database.getReference("cars")

        database.child("cars").child("car1").setValue("kia")

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val spinnerArray = ArrayList<String>()

                for (zoneSnapshot in dataSnapshot.children) {
                    if (zoneSnapshot.value != null) spinnerArray.add(zoneSnapshot.value.toString())
                }


                val spinnerArrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
                carsSpinner?.adapter = spinnerArrayAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Amir", "Failed to read value.", error.toException())
            }
        })

        signOut?.setOnClickListener {
            FirebaseAuth.AuthStateListener { firebaseAuth ->
                val user = firebaseAuth.currentUser
                if (user == null) {
                    signOut()
                    //startActivity(Intent(this@ReservationActivity, LoginActivity::class.java))
                   // finish()
                }

            }

        }

    }

    private fun signOut() {
        // [START auth_sign_out]
//        auth?.signOut()
//        startActivity(Intent(this@ReservationActivity, LoginActivity::class.java))
//        finish()
        // [END auth_sign_out]
    }
}
