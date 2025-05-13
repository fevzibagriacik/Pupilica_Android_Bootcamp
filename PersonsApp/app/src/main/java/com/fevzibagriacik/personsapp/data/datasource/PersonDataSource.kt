package com.fevzibagriacik.personsapp.data.datasource

import android.util.Log
import com.fevzibagriacik.personsapp.data.entity.Kisiler
import com.fevzibagriacik.personsapp.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataSource(var kisilerDao:KisilerDao) {
    suspend fun save(person_name:String, person_number:String){
        val newPerson = Kisiler(0, person_name, person_number)
        kisilerDao.save(newPerson)
    }

    suspend fun update(person_id:Int, person_name:String, person_number:String){
        val updatedPerson = Kisiler(person_id, person_name, person_number)
        kisilerDao.update(updatedPerson)
    }

    suspend fun delete(person_id:Int){
        Log.e("Delete Person", person_id.toString())
    }

    suspend fun uploadPersons() : List<Kisiler> = withContext(Dispatchers.IO){
        return@withContext kisilerDao.uploadPersons()
    }

    suspend fun search(searchWord:String) : List<Kisiler> = withContext(Dispatchers.IO){
        val list = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Ahmet", "1111")
        list.add(k1)

        return@withContext list
    }
}