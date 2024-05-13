package com.example.estimatedage.source

import com.example.estimatedage.model.Person
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PersonService {
    @GET("/")
    suspend fun findPerson(
        @Query("name") name: String
    ): Person

}