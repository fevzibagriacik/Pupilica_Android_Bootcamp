package com.fevzibagriacik.workingstructures

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fevzibagriacik.workingstructures.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //transfers the design
        setContentView(binding.root) //provides the connection

        binding.buttonDetail.setOnClickListener{
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("message", "Hi, how are you?")
            startActivity(intent)
        }
    }
}