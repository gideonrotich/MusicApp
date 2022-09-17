package com.example.musicapp.data.mapper

import com.example.musicapp.data.dto.Result
import com.example.musicapp.domain.models.Music

fun Result.toDomain():Music{
    return Music(
        annotation_count, api_path, artist_names, featured_artists, full_title, header_image_thumbnail_url, header_image_url, id, language, lyrics_owner_id, lyrics_state, path, primary_artist, pyongs_count, relationships_index_url, release_date_components, release_date_for_display, song_art_image_thumbnail_url, song_art_image_url, stats, title, title_with_featured, url
    )
}