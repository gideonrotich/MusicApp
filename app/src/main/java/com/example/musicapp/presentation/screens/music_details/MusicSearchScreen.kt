package com.example.musicapp.presentation.screens.music_details

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.musicapp.R
import com.example.musicapp.presentation.components.MainAppBar
import com.example.musicapp.presentation.components.SearchWidgetState
import com.example.musicapp.util.gifLoader

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MusicSearchScreen(navController: NavHostController, viewModel: SearchMusicViewModel = hiltViewModel()){
    val state by viewModel.state
    val searchWidgetState by viewModel.searchWidgetState
    val searchString by viewModel.searchString
    val scaffoldState = rememberScaffoldState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchStringState = searchString,
                onTextChange = {
                    viewModel.setSearchString(it)
                },
                onCloseClicked = {
                    viewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                    viewModel.getMusic(it.trim())
                    keyboardController?.hide()
                },
                onSearchTriggered = {
                    viewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)
                }
            )
        }
    ){
        Box(modifier = Modifier.fillMaxSize()) {
            if (state.music != null && !state.isLoading){
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.music) { music ->
                        GrandPixListItem(
                            grandpix = music,
                        )
                        Spacer(Modifier.height(15.dp))
                    }
                }
            }else if (state.music == null && !state.isLoading) {
                EmptyStateGifImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .align(Alignment.Center),
                    context = context,
                )
            }
            if (state.isLoading) {
                LoadingGif(
                    context = context,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}


@Composable
fun LoadingGif(
    context: Context,
    modifier: Modifier = Modifier
) {
    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = R.drawable.octocat).apply(block = {
                size(Size.ORIGINAL)
            }).build(), imageLoader = context.gifLoader()
        ),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
    )
}

@Composable
fun EmptyStateGifImage(
    modifier: Modifier = Modifier,
    context: Context
) {

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context).data(data = com.example.musicapp.R.drawable.search).apply(block = {
                    size(Size.ORIGINAL)
                }).build(), imageLoader = context.gifLoader()
            ),
            contentDescription = "Empty State Gif",
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
        )
        Text(
            text = "Search for a user to see their profile",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}