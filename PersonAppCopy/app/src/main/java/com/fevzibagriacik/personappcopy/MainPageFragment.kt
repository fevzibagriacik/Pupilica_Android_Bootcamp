package com.fevzibagriacik.personappcopy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.fevzibagriacik.personappcopy.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.rvMainPage.layoutManager = LinearLayoutManager(requireContext())
        val personList = ArrayList<Persons>()
        val p1 = Persons(1, "Ahmet", "111")
        val p2 = Persons(2, "Ali", "222")
        val p3 = Persons(3, "Buse", "333")
        personList.add(p1)
        personList.add(p2)
        personList.add(p3)
        val adapter = PersonsAdapter(requireContext(), personList)
        binding.rvMainPage.adapter = adapter

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }
        })

        binding.fabAdd.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toPersonRecord)
        }

        return binding.root
    }

    fun search(searchWord:String){
        Log.e("Search Person", searchWord)
    }
}