package com.fevzibagriacik.personsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.fevzibagriacik.personsapp.R
import com.fevzibagriacik.personsapp.databinding.FragmentPersonRecordBinding
import com.fevzibagriacik.personsapp.ui.viewmodel.PersonRecordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonRecordFragment : Fragment() {
    private lateinit var binding: FragmentPersonRecordBinding
    private lateinit var viewModel: PersonRecordViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonRecordBinding.inflate(inflater, container, false)

        binding.buttonSave.setOnClickListener{
            val person_name = binding.editTextPersonName.text.toString()
            val person_number = binding.editTextPersonNumber.text.toString()
            viewModel.save(person_name, person_number)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel:PersonRecordViewModel by viewModels()
        viewModel = tempViewModel
    }
}