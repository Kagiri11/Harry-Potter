package com.example.harrypotter.data.remote

import com.example.harrypotter.models.Staff
import com.example.harrypotter.models.Students
import com.example.harrypotter.models.StudentsItem
import retrofit2.Response
import retrofit2.http.GET

interface PotterService {
    @GET("characters/students")
    suspend fun getStudents():Response<Students>

    @GET("characters/staff")
    suspend fun getStaff():Response<Staff>
}