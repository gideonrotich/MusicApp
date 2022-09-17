package com.example.musicapp.data.dto

data class Result(
    val annotation_count: Int,
    val api_path: String,
    val artist_names: String,
    val featured_artists: List<FeaturedArtist>,
    val full_title: String,
    val header_image_thumbnail_url: String,
    val header_image_url: String,
    val id: Int,
    val language: String,
    val lyrics_owner_id: Int,
    val lyrics_state: String,
    val path: String,
    val primary_artist: PrimaryArtist,
    val pyongs_count: Int,
    val relationships_index_url: String,
    val release_date_components: ReleaseDateComponents,
    val release_date_for_display: String,
    val song_art_image_thumbnail_url: String,
    val song_art_image_url: String,
    val stats: Stats,
    val title: String,
    val title_with_featured: String,
    val url: String
)