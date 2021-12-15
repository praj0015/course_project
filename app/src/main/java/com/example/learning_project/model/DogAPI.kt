package com.example.learning_project.model

import io.reactivex.Single
import retrofit2.http.GET

interface DogAPI {

    @GET("/DevTides/DogsApi/master/dogs.json")
    fun getDogs() : Single<List<DogBreed>>  // Single is observable
}