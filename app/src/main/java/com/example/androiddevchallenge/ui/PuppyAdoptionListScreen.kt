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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.getPuppies
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.glide.GlideImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

@Composable
fun PuppyAdoptionScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Adopt a pup!")
                }
            )
        },
        bottomBar = {
            BottomAppBar {}
        }
    ) {
        PuppyList()
    }
}

@Composable
fun PuppyList() {
    val puppies = getPuppies()

    LazyColumn {
        items(
            puppies,
            itemContent = { puppy ->
                PuppyItem(puppy)
            }
        )
    }
}

@Composable
fun PuppyItem(puppy: Puppy) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 3.dp
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = puppy.name,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, top = 10.dp),
                style = MaterialTheme.typography.h4
            )

            val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.french_bulldog) }

            GlideImage(
                data = puppy.picture,
            ) { imageState ->
                when (imageState) {
                    is ImageLoadState.Success -> {
                        MaterialLoadingImage(
                            result = imageState,
                            puppy.name,
                            fadeInEnabled = true,
                            fadeInDurationMs = 600,
                            modifier = Modifier.width(150.dp)
                        )
                    }
                    is ImageLoadState.Error -> {
                        LottieAnimation(
                            animationSpec,
                            modifier = Modifier.requiredWidth(80.dp).requiredHeight(150.dp)
                        )
                    }
                    is ImageLoadState.Loading -> {
                        LottieAnimation(
                            animationSpec,
                            modifier = Modifier.requiredWidth(80.dp).requiredHeight(150.dp)
                        )
                    }
                    is ImageLoadState.Empty -> {
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
        PuppyAdoptionScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyAdoptionScreen()
    }
}
