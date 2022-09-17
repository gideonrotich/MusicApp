package com.example.musicapp.presentation.screens.music_details


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.musicapp.R
import com.example.musicapp.domain.models.Music
import com.example.musicapp.presentation.components.VoteAverageRatingIndicator
import com.example.musicapp.ui.theme.DarkGray
import com.example.musicapp.ui.theme.Teal200


@Composable
fun GrandPixListItem(grandpix: Music) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 10.dp, 10.dp, 0.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        backgroundColor = Color.White
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .height(250.dp)) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)) {
                    Row(modifier = Modifier.width(120.dp)) {
                        val image: Painter = rememberImagePainter(data = grandpix.header_image_thumbnail_url)

                        Image(
                            modifier = Modifier
                                .height(130.dp)
                                .padding(10.dp)
                                .width(120.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            painter = image,
                            alignment = Alignment.Center,
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )

                    }

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.Top)) {
                        Text(
                            text = "Name: "+grandpix.artist_names!!,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(6.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color = colorResource(id = R.color.purple_500),
                            maxLines = 1
                        )
                        Text(
                            text = "Title: "+grandpix.title!!,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(6.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black,
                            maxLines = 1
                        )
                        Text(
                            text = "Id: "+grandpix.id!!,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(6.dp),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black,
                            maxLines = 1
                        )


                    }
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.width(230.dp)) {
                        Text(
                            text = "Song: "+grandpix.full_title!!,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(6.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.SansSerif,
                            color =  colorResource(id = R.color.pink),
                            maxLines = 1
                        )
                        Text(
                            text = "Featured Artist: "+grandpix.primary_artist?.name!!,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(6.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black,
                            maxLines = 1
                        )
                        Text(
                            text = "Progress: "+grandpix.lyrics_state!!,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(6.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black,
                            maxLines = 1
                        )
                    }
                    Column(modifier = Modifier.fillMaxWidth()) {
                        if (grandpix.release_date_components?.day != null){
                            VoteAverageRatingIndicator(
                                modifier = Modifier
                                    .fillMaxWidth(0.17f),
                                percentage = grandpix.release_date_components!!.day.toFloat()
                            )
                        }
                        if(grandpix.release_date_components?.day == null){
                            val rating = 50
                            VoteAverageRatingIndicator(
                                modifier = Modifier
                                    .fillMaxWidth(0.17f),
                                percentage = rating.toFloat()
                            )
                        }
                        Text(
                            text = "  Rating",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(6.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily.SansSerif,
                            color = Color.Black,
                            maxLines = 1
                        )


                    }


                }
            }



        }
    }
}



