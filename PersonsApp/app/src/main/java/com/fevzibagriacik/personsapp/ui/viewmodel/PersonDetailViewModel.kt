package com.fevzibagriacik.personsapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.fevzibagriacik.personsapp.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(var personRepository:PersonRepository): ViewModel(){

    fun update(person_id:Int, person_name:String, person_number:String){
        CoroutineScope(Dispatchers.Main).launch {
            personRepository.update(person_id, person_name, person_number)
        }
    }
}