package com.example.musicapp.presentation.screens.music_details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicapp.domain.usecases.GetMusicUseCase
import com.example.musicapp.presentation.components.SearchWidgetState
import com.example.musicapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchMusicViewModel @Inject constructor(
    private val getMusicUseCase: GetMusicUseCase
):ViewModel(){

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    private val _searchString = mutableStateOf("")
    val searchString: State<String> = _searchString

    fun setSearchString(value: String) {
        _searchString.value = value
    }

    private val _state = mutableStateOf(MusicDataState())
    val state:State<MusicDataState> = _state

   fun getMusic(q:String){
       getMusicUseCase(q).onEach { result ->
           when(result){
               is Resource.Success -> {
                   _state.value = MusicDataState(music = result.data ?: emptyList())
               }
               is Resource.Error -> {
                   _state.value = MusicDataState(error = result.message ?: "An unexpected error occured")
               }
               is Resource.Loading -> {
                   _state.value = MusicDataState(isLoading = true)
               }
           }
       }.launchIn(viewModelScope)
   }

}