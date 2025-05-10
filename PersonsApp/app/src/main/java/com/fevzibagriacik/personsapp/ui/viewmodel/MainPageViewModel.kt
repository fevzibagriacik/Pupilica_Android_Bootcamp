package com.fevzibagriacik.personsapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fevzibagriacik.personsapp.data.entity.Kisiler
import com.fevzibagriacik.personsapp.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(var personRepository:PersonRepository) : ViewModel() {
    var personList = MutableLiveData<List<Kisiler>>()

    init {
        uploadPersons()
    }

    fun delete(person_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            personRepository.delete(person_id)
            uploadPersons()
        }
    }

    fun uploadPersons(){
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = personRepository.uploadPersons() //Trigger
        }
    }

    fun search(searchWord:String){
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = personRepository.search(searchWord) //Trigger
        }
    }
}