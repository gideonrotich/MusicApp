package com.example.musicapp.domain.repository

import com.example.musicapp.data.dto.Hit
import com.example.musicapp.data.dto.MusicResponseDto
import com.example.musicapp.data.dto.Response
import com.example.musicapp.data.dto.Result

interface MusicRepository {
    suspend fun getMusic(q:String):MusicResponseDto
}