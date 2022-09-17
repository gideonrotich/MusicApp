package com.example.musicapp.data.repository

import com.example.musicapp.data.api.MusicApi
import com.example.musicapp.data.dto.Hit
import com.example.musicapp.data.dto.MusicResponseDto
import com.example.musicapp.data.dto.Response
import com.example.musicapp.data.dto.Result
import com.example.musicapp.domain.repository.MusicRepository
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val api:MusicApi
):MusicRepository {
    override suspend fun getMusic(q: String): MusicResponseDto {
        return api.getMusic(q)
    }
}