package com.fevzibagriacik.personsapp.di

import com.fevzibagriacik.personsapp.data.datasource.PersonDataSource
import com.fevzibagriacik.personsapp.data.repo.PersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun providePersonDataSource() : PersonDataSource{
        return PersonDataSource()
    }
}