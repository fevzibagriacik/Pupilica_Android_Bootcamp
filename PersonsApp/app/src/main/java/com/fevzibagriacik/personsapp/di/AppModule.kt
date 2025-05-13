package com.fevzibagriacik.personsapp.di

import android.content.Context
import androidx.room.Room
import com.fevzibagriacik.personsapp.data.datasource.PersonDataSource
import com.fevzibagriacik.personsapp.data.repo.PersonRepository
import com.fevzibagriacik.personsapp.room.Database
import com.fevzibagriacik.personsapp.room.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonRepository(personDataSource:PersonDataSource) : PersonRepository{
        return PersonRepository(personDataSource)
    }

    @Provides
    @Singleton
    fun providePersonDataSource(kisilerDao: KisilerDao) : PersonDataSource{
        return PersonDataSource(kisilerDao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context:Context) : KisilerDao{
        val database = Room.databaseBuilder(context, Database::class.java, "person.sqlite")
            .createFromAsset("person.sqlite")
            .build()
        return database.getPersonsDao()
    }
}