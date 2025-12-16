package com.example.demolifecycle

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.example.demolifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var score =0
    val viewModel: ScoreViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

        binding.viewModel = viewModel

        var btn = findViewById<Button>(R.id.btnInc)
        var txt = findViewById<TextView>(R.id.txtScore)
//        btn.setOnClickListener {
//            viewModel.score++
//            txt.text=""+viewModel.score
//        }
        binding.btnInc.setOnClickListener {
            viewModel.score.value=viewModel.score.value+1
            //txt.text=""+viewModel.score
        }
        val score_Observer = Observer<Int> { newValue ->
            binding.txtScore.text = newValue.toString()
        }
        viewModel.score.observe(this,score_Observer)
    }

}
class ScoreViewModel : ViewModel() {
     var score= MutableLiveData<Int>(0)
}


