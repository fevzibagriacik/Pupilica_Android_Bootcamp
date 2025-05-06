package com.fevzibagriacik.personsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fevzibagriacik.personsapp.R
import com.fevzibagriacik.personsapp.databinding.FragmentPersonRecordBinding

class PersonRecordFragment : Fragment() {
    private lateinit var binding: FragmentPersonRecordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonRecordBinding.inflate(inflater, container, false)

        binding.buttonSave.setOnClickListener{
            val person_name = binding.editTextPersonName.text.toString()
            val person_number = binding.editTextPersonNumber.text.toString()
            save(person_name, person_number)

        }

        return binding.root
    }

    fun save(person_name:String, person_number:String){
        Log.e("Save Person", "$person_name - $person_number")
    }
}