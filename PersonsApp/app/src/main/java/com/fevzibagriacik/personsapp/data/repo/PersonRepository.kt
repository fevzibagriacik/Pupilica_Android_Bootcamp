package com.fevzibagriacik.personsapp.data.repo

import android.util.Log
import com.fevzibagriacik.personsapp.data.datasource.PersonDataSource
import com.fevzibagriacik.personsapp.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonRepository(var personDataSource:PersonDataSource) {

    suspend fun save(person_name:String, person_number:String) =
        personDataSource.save(person_name, person_number)

    suspend fun update(person_id:Int, person_name:String, person_number:String) =
        personDataSource.update(person_id, person_name, person_number)

    suspend fun delete(person_id:Int) = personDataSource.delete(person_id)

    suspend fun uploadPersons() : List<Kisiler> = personDataSource.uploadPersons()

    suspend fun search(searchWord:String) : List<Kisiler> = personDataSource.search(searchWord)

}