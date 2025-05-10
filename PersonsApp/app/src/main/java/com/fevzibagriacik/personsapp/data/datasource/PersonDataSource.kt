package com.fevzibagriacik.personsapp.data.datasource

import android.util.Log
import com.fevzibagriacik.personsapp.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataSource {
    suspend fun save(person_name:String, person_number:String){
        Log.e("Save Person", "$person_name - $person_number")
    }

    suspend fun update(person_id:Int, person_name:String, person_number:String){
        Log.e("Update Person", "$person_id - $person_name - $person_number")
    }

    suspend fun delete(person_id:Int){
        Log.e("Delete Person", person_id.toString())
    }

    suspend fun uploadPersons() : List<Kisiler> = withContext(Dispatchers.IO){
        val list = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "1111")
        val k2 = Kisiler(2, "Zeynep", "2222")
        val k3 = Kisiler(3, "Beyza", "3333")
        list.add(k1)
        list.add(k2)
        list.add(k3)

        return@withContext list
    }

    suspend fun search(searchWord:String) : List<Kisiler> = withContext(Dispatchers.IO){
        val list = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "1111")
        list.add(k1)

        return@withContext list
    }
}