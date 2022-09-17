package com.example.musicapp.domain.usecases

import com.example.musicapp.data.mapper.toDomain
import com.example.musicapp.domain.models.Music
import com.example.musicapp.domain.repository.MusicRepository
import com.example.musicapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMusicUseCase @Inject constructor(
    private val repository: MusicRepository
) {
    operator fun invoke(q:String):Flow<Resource<List<Music>>> = flow {
        try {
            emit(Resource.Loading())
            val data  = repository.getMusic(q).response.hits!!.map { it.result.toDomain() }
            emit(Resource.Success(data))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Error"))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "one error"))
        }
    }
}