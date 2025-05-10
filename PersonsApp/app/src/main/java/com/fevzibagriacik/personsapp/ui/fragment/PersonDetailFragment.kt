package com.fevzibagriacik.personsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.fevzibagriacik.personsapp.R
import com.fevzibagriacik.personsapp.databinding.FragmentPersonDetailBinding
import com.fevzibagriacik.personsapp.ui.viewmodel.PersonDetailViewModel
import com.fevzibagriacik.personsapp.ui.viewmodel.PersonRecordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding
    private lateinit var viewModel:PersonDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater, container, false)

        val bundle:PersonDetailFragmentArgs by navArgs()
        val comingPerson = bundle.person

        binding.editTextPersonName.setText(comingPerson.kisi_ad)
        binding.editTextPersonNumber.setText((comingPerson.kisi_tel))

        binding.buttonUpdate.setOnClickListener{
            val person_name = binding.editTextPersonName.text.toString()
            val person_number = binding.editTextPersonNumber.text.toString()
            viewModel.update(comingPerson.kisi_id, person_name, person_number)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: PersonDetailViewModel by viewModels()
        viewModel = tempViewModel
    }
}