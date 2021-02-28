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
package com.example.androiddevchallenge

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.model.Puppy

fun getPuppies() = listOf(
    Puppy(
        "Dog 1",
        "https://images.pexels.com/photos/936317/pexels-photo-936317.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        2,
        "Brown/White",
        Color(0xffb4b2a6)
    ),
    Puppy(
        "Dog 2",
        "https://images.pexels.com/photos/179221/pexels-photo-179221.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        3,
        "Black/White",
        Color(0xff585e6a)
    ),
    Puppy(
        "Dog 3",
        "https://images.pexels.com/photos/1480913/pexels-photo-1480913.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        6,
        "Brown",
        Color(0xffa9866a)
    ),
    Puppy(
        "Dog 4",
        "https://images.pexels.com/photos/5321441/pexels-photo-5321441.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        2,
        "Light brown",
        Color(0xffc7afaa)
    ),
    Puppy(
        "Dog 5",
        "https://images.pexels.com/photos/4597758/pexels-photo-4597758.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        5,
        "Light brown",
        Color(0xffbf916d)
    ),
    Puppy(
        "Dog 6",
        "https://images.pexels.com/photos/4695939/pexels-photo-4695939.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        8,
        "Black",
        Color(0xff4e4a47)
    ),
)
