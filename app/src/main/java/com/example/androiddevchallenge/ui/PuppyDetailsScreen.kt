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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun PuppyDetailsScreen(puppy: Puppy, navigateBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = puppy.name)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navigateBack()
                        }
                    ) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) {
        Column {
            if (puppy.picture.isNotEmpty()) {
                GlideImage(data = puppy.picture, puppy.name)
            } else {
                Box(
                    modifier = Modifier
                        .size(LocalConfiguration.current.screenWidthDp.dp)
                        .background(Color.DarkGray)
                ) {
                    Text(text = "Image of puppy", modifier = Modifier.align(Alignment.Center))
                }
            }

            Text(
                text = puppy.name,
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp),
                style = MaterialTheme.typography.h3
            )

            Row(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                    Text(text = "Age:")
                    Text(text = "Color:")
                }
                Column(modifier = Modifier.fillMaxWidth(0.5f)) {
                    Text(text = "${puppy.age} years")
                    Text(text = puppy.color)
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyDetailsScreenLightPreview() {
    MyTheme {
        PuppyDetailsScreen(Puppy("Puppy", "", 4, "Black")) {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyDetailsScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyDetailsScreen(Puppy("Puppy", "", 6, "Grey")) {}
    }
}
