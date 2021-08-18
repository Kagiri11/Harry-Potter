package com.example.harrypotter.data.remote

import retrofit2.http.GET

interface PotterService {
    @GET("characters")
    suspend fun getStudents():List<CharacterNetworkEntity>
}