package com.fevzibagriacik.foodapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fevzibagriacik.foodapp.databinding.FragmentRecordBinding
import com.fevzibagriacik.foodapp.ui.viewmodel.DetailViewModel
import com.fevzibagriacik.foodapp.ui.viewmodel.RecordViewModel

class RecordFragment : Fragment() {
    private lateinit var binding: FragmentRecordBinding
    private lateinit var viewModel : RecordViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecordBinding.inflate(inflater, container, false)

        binding.btnSave.setOnClickListener {
            val foodName = binding.etName.text.toString()
            val foodPrice = binding.etPrice.text.toString()
            viewModel.save(foodName, foodPrice)
        }

        return binding.root
    }
}