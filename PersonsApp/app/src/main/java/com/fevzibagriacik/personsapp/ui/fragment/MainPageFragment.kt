package com.fevzibagriacik.personsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fevzibagriacik.personsapp.R
import com.fevzibagriacik.personsapp.data.entity.Kisiler
import com.fevzibagriacik.personsapp.databinding.FragmentMainPageBinding
import com.fevzibagriacik.personsapp.ui.adapter.PersonsAdapter

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toPersonRecord)
        }

        val personsList = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "1111")
        val k2 = Kisiler(2, "Zeynep", "2222")
        val k3 = Kisiler(3, "Beyza", "3333")
        personsList.add(k1)
        personsList.add(k2)
        personsList.add(k3)

        val personsAdapter = PersonsAdapter(requireContext(), personsList)
        binding.personsRv.adapter = personsAdapter

        binding.personsRv.layoutManager = LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }
        })

        return binding.root
    }

    fun search(wordSearching:String){
        Log.e("Search Person", wordSearching)
    }

    override fun onResume() {
        super.onResume()
        Log.e("Returned to the", "Main Page")
    }
}