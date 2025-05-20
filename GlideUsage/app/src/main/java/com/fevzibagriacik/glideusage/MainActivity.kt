package com.fevzibagriacik.glideusage

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.fevzibagriacik.glideusage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foods = listOf("izgarasomon.png","izgaratavuk.png","kofte.png","lazanya.png","makarna.png","pizza.png")
        val deserts = listOf("baklava.png","kadayif.png","sutlac.png","tiramisu.png")
        val drinks = listOf("ayran.png","fanta.png","kahve.png","su.png")

        binding.btnCreateMenu.setOnClickListener {
            val food = foods.random()
            val desert = deserts.random()
            val drink = drinks.random()

            showImage(food, binding.ivFoods)
            showImage(desert, binding.ivDeserts)
            showImage(drink, binding.ivDrinks)
        }
    }

    fun showImage(imageName:String, imageView:ImageView){
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$imageName"
        Glide.with(this).load(url).override(300,300)
            .into(imageView)
    }
}