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
package com.example.androiddevchallenge.ui.overview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen
import com.example.androiddevchallenge.data.Pet
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetsOverviewScreen(pets: List<Pet>, navigateTo: (Screen) -> Unit) {
    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.pets_overview_screen)
            TopAppBar(title = { Text(text = title) })
        },
        content = {
            PetList(pets = pets, navigateTo = navigateTo)
        }
    )
}

@Composable
fun PetList(pets: List<Pet>, navigateTo: (Screen) -> Unit) {
    LazyColumn(Modifier.fillMaxWidth()) {
        items(pets) { pet ->
            BuildPet(pet = pet, navigateTo)
            Divider()
        }
    }
}

@Composable
fun BuildPet(pet: Pet, navigateTo: (Screen) -> Unit) {
    Row(modifier = Modifier.clickable(onClick = { navigateTo(Screen.Detail(pet.id)) })) {
        CoilImage(
            data = pet.photos[0], contentDescription = stringResource(id = R.string.pet_image_content_description),
            modifier = Modifier
                .padding(16.dp)
                .shadow(1.dp)
                .size(56.dp, 72.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.padding(PaddingValues(top = 16.dp, end = 16.dp, bottom = 16.dp))) {
            Text(text = pet.name, style = MaterialTheme.typography.h6)
            Text(
                text = pet.description,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}
