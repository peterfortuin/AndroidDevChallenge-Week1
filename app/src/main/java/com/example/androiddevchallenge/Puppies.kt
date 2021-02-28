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
        "Abby",
        "https://images.pexels.com/photos/936317/pexels-photo-936317.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        2,
        "Brown/White",
        Color(0xffafb8bd),
        Color(0xffbcc5ca)
    ),
    Puppy(
        "Brutus",
        "https://images.pexels.com/photos/179221/pexels-photo-179221.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        3,
        "Black/White",
        Color(0xff9fa3a8),
        Color(0xffbabbbf)
    ),
    Puppy(
        "Georgia",
        "https://images.pexels.com/photos/1480913/pexels-photo-1480913.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        6,
        "Brown",
        Color(0xffd0b79d),
        Color(0xffc8a989)
    ),
    Puppy(
        "Hunter",
        "https://images.pexels.com/photos/5321441/pexels-photo-5321441.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        2,
        "Light brown",
        Color(0xffc7afaa),
        Color(0xffbf7a59)
    ),
    Puppy(
        "Mabel",
        "https://images.pexels.com/photos/4597758/pexels-photo-4597758.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        5,
        "Light brown",
        Color(0xffd4a57b),
        Color(0xffe7aa73)
    ),
    Puppy(
        "Parker",
        "https://images.pexels.com/photos/4695939/pexels-photo-4695939.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500",
        8,
        "Black",
        Color(0xffa7a5a3),
        Color(0xffbfb7b0)
    ),
)
