package com.fevzibagriacik.personappcopy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.fevzibagriacik.personappcopy.databinding.FragmentPersonDetailBinding

class PersonDetailFragment : Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater, container, false)

        val bundle:PersonDetailFragmentArgs by navArgs()
        val comingPerson = bundle.person

        binding.editTextPersonName.setText(comingPerson.person_name)
        binding.editTextPersonNumber.setText(comingPerson.person_number)

        binding.buttonUpdate.setOnClickListener {
            val person_name = binding.editTextPersonName.text.toString()
            val person_number = binding.editTextPersonNumber.text.toString()
            update(comingPerson.person_id, person_name, person_number)
        }

        return binding.root
    }

    fun update(person_id:Int, person_name:String, person_number:String){
        Log.e("Update Person", "$person_id - $person_name - $person_number")
    }
}