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

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

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
    ) {}
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyDetailsScreenLightPreview() {
    MyTheme {
        PuppyDetailsScreen(Puppy("Puppy", "")) {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PuppyDetailsScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyDetailsScreen(Puppy("Puppy", "")) {}
    }
}
