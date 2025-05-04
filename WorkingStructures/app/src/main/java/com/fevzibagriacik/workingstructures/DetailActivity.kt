package com.fevzibagriacik.workingstructures

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fevzibagriacik.workingstructures.databinding.ActivityDetailBinding
import com.fevzibagriacik.workingstructures.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val comingMessage = intent.getStringExtra("message")

        binding.textViewResult.text = comingMessage
    }
}