package com.fevzibagriacik.personsapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fevzibagriacik.personsapp.data.entity.Kisiler

@Dao
interface KisilerDao { //Dao: Database Access Object
    @Query("SELECT * FROM persons")
    suspend fun uploadPersons() : List<Kisiler>

    @Insert
    suspend fun save(kisi : Kisiler)

    @Update
    suspend fun update(kisi : Kisiler)
}