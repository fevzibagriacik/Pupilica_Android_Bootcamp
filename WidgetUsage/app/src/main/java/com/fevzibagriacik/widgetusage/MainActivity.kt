package com.fevzibagriacik.widgetusage

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fevzibagriacik.widgetusage.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var control = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            control = isChecked
            if(isChecked){
                val selectedButton = findViewById<Button>(checkedId)
                val buttonText = selectedButton.text.toString()
                Log.e("Result", buttonText)
            }
        }

        val countries = ArrayList<String>()
        countries.add("Turkey")
        countries.add("Germany")
        countries.add("Japanese")

        val arrayAdapter = ArrayAdapter(this, R.layout.simple_list_item_1, countries)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.buttonShow.setOnClickListener{
            if(control){
                val selectedButton = findViewById<Button>(binding.toggleButton.checkedButtonId)
                val buttonText = selectedButton.text.toString()
                Log.e("Result (Show)", buttonText)
            }

            val selectedCountry = binding.autoCompleteTextView.text.toString()
            Log.e("Result", selectedCountry)
        }

        binding.buttonAlert.setOnClickListener{
            MaterialAlertDialogBuilder(this)
                .setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("OK"){d,i ->
                    Toast.makeText(this,"OK Clicked.", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel"){d,i ->
                    Toast.makeText(this,"Cancel Clicked.", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}