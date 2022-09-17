package com.example.musicapp.data.dto

data class PrimaryArtist(
    val api_path: String,
    val header_image_url: String,
    val id: Int,
    val image_url: String,
    val is_meme_verified: Boolean,
    val is_verified: Boolean,
    val name: String,
    val url: String
)