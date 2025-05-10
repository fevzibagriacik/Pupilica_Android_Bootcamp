package com.fevzibagriacik.personsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fevzibagriacik.personsapp.R
import com.fevzibagriacik.personsapp.data.entity.Kisiler
import com.fevzibagriacik.personsapp.databinding.FragmentMainPageBinding
import com.fevzibagriacik.personsapp.ui.adapter.PersonsAdapter
import com.fevzibagriacik.personsapp.ui.viewmodel.MainPageViewModel
import com.fevzibagriacik.personsapp.ui.viewmodel.PersonRecordViewModel
import com.fevzibagriacik.personsapp.utils.makeTransition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment() {
    private lateinit var binding:FragmentMainPageBinding
    private lateinit var viewModel:MainPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener{
            Navigation.makeTransition(it, R.id.toPersonRecord)
        }

        viewModel.personList.observe(viewLifecycleOwner){ //Listenning
            val personsAdapter = PersonsAdapter(requireContext(), it, viewModel)
            binding.personsRv.adapter = personsAdapter
        }

        binding.personsRv.layoutManager = LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.uploadPersons()
    }
}