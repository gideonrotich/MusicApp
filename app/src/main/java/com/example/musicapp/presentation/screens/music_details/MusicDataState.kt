package com.example.musicapp.presentation.screens.music_details

import com.example.musicapp.domain.models.Music

data class MusicDataState(
    val isLoading:Boolean = false,
    val music:List<Music> = emptyList(),
    val error:String = ""
)
