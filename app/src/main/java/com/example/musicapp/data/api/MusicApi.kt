package com.example.musicapp.data.api

import com.example.musicapp.data.dto.Hit
import com.example.musicapp.data.dto.MusicResponseDto
import com.example.musicapp.data.dto.Response
import com.example.musicapp.data.dto.Result
import com.example.musicapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MusicApi {
    @Headers(
        "X-RapidAPI-Key: 784ff288e0mshb6844374932e291p142557jsn4b8986ede27b",
        "X-RapidAPI-Host': 'genius.p.rapidapi.com"
    )

    @GET(Constants.GET_MUSIC)
    suspend fun getMusic(@Query("q")q:String):MusicResponseDto
}