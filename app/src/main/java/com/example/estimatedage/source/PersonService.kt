package com.example.estimatedage.source

import com.example.estimatedage.model.Person
import retrofit2.http.GET
import retrofit2.http.Query

interface PersonService {
    @GET
    suspend fun findPerson(
        @Query("name") name: String
    ): Person

}