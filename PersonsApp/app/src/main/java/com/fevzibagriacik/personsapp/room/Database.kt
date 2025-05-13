package com.fevzibagriacik.personsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fevzibagriacik.personsapp.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun getPersonsDao() : KisilerDao
}