/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.getPuppies
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.glide.GlideImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

@Composable
fun PuppyAdoptionScreen(openPuppy: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Adopt a pup!")
                }
            )
        }
    ) {
        PuppyList(openPuppy)
    }
}

@Composable
fun PuppyList(openPuppy: (String) -> Unit) {
    val puppies = getPuppies()

    LazyColumn {
        itemsIndexed(
            puppies,
            itemContent = { index, puppy ->
                PuppyCard(puppy, index == 0, index == puppies.size - 1, openPuppy)
            }
        )
    }
}

@Composable
fun PuppyCard(puppy: Puppy, isFirst: Boolean, isLast: Boolean, openPuppy: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = if (isFirst) 10.dp else 5.dp,
                bottom = if (isLast) 10.dp else 5.dp
            )
            .clickable {
                openPuppy(puppy.name)
            },
        elevation = 3.dp
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text(
                    text = puppy.name,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp),
                    style = MaterialTheme.typography.h5
                )
            }

            val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.french_bulldog) }
            val animationState = rememberLottieAnimationState(
                autoPlay = true,
                repeatCount = Int.MAX_VALUE
            )

            Row(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            ) {
                GlideImage(
                    data = puppy.picture,
                    modifier = Modifier.fillMaxWidth()
                ) { imageState ->
                    when (imageState) {
                        is ImageLoadState.Success -> {
                            MaterialLoadingImage(
                                result = imageState,
                                puppy.name,
                                fadeInEnabled = true,
                                fadeInDurationMs = 600,
                            )
                        }
                        is ImageLoadState.Error -> {
                            LottieAnimation(
                                animationSpec,
                                modifier = Modifier.align(Alignment.Center),
                                animationState = animationState
                            )
                        }
                        is ImageLoadState.Loading -> {
                            LottieAnimation(
                                animationSpec,
                                modifier = Modifier.align(Alignment.Center),
                                animationState = animationState
                            )
                        }
                        is ImageLoadState.Empty -> {
                        }
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        PuppyAdoptionScreen {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyAdoptionScreen {}
    }
}
