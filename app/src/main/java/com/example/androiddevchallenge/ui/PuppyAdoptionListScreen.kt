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

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

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
    val puppies = listOf<Puppy>(
        Puppy("Dog 1", ""),
        Puppy("Dog 2", ""),
        Puppy("Dog 3", ""),
        Puppy("Dog 4", ""),
        Puppy("Dog 5", ""),
        Puppy("Dog 6", ""),
    )
    LazyColumn() {
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
    Row(modifier = Modifier.padding(10.dp)) {
        Text(text = puppy.name)
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
