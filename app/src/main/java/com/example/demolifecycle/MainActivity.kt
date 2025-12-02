package com.example.demolifecycle

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var score =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<Button>(R.id.btnInc)
        var txt = findViewById<TextView>(R.id.txtScore)
        btn.setOnClickListener {
            score++
            txt.text=""+score
        }
        if(savedInstanceState!=null)
        {
            score = savedInstanceState.getInt("score")
            txt.text=""+score
        }
        Log.d("TESTLC","CREATED")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("score",score)
    }
    override fun onStart() {
        super.onStart()
        Log.v("TESTLC","STARTED")
        Log.i("TESTLC","STARTED")
        Log.d("TESTLC","STARTED")
        Log.e("TESTLC","STARTED")
    }
    override fun onResume(){
        super.onResume()
        Log.d("TESTLC","RESUMED")
    }
    override fun onPause(){
        super.onPause()
        Log.d("TESTLC","PAUSED")
    }
    override fun onStop(){
        super.onStop()
        Log.d("TESTLC","STOPPED")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TESTLC","DESTROYED")
    }
}