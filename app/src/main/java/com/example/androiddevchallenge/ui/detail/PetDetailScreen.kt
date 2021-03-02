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
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.PetsData
import dev.chrisbanes.accompanist.coil.CoilImage
import java.lang.IllegalArgumentException

/**
 * ViewModel with repository has to be used, but for now load
 * from dummy data.
 */
@Composable
fun PetDetailScreen(petId: Int) {
    val pet = PetsData.pets.find { it.id == petId }
    val title = stringResource(
        id = R.string.pet_detail_screen,
        pet?.name ?: throw IllegalArgumentException("Pet doesn't exist")
    )
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = title) })
        },
        content = { padding ->
            val modifier = Modifier.padding(padding)
            PetDetail(pet, modifier)
        }
    )
}

@Composable
fun PetDetail(pet: Pet?, modifier: Modifier) {
    requireNotNull(pet)
    LazyColumn(
        modifier = modifier.padding(top = 16.dp)
    ) {
        item {
            PetPhotoList(pet)
        }

        item {
            PetDetailRow(R.string.pet_breed, pet.breed)
            Spacer(Modifier.height(8.dp))
        }
        item {
            PetDetailRow(R.string.pet_color, pet.color)
            Spacer(Modifier.height(8.dp))
        }
        item {
            PetDetailRow(R.string.pet_age, pet.age)
            Spacer(Modifier.height(16.dp))
        }

        item {
            Text(
                text = pet.description,
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.subtitle1,
            )
            Spacer(Modifier.height(8.dp))
        }
        item {
            Button(
                onClick = { },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(text = stringResource(id = R.string.action_contact))
            }
        }
    }
}

@Composable
private fun PetPhotoList(pet: Pet) {
    LazyRow {
        items(pet.photos) { photo ->
            Card(
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 16.dp)
                    .size(220.dp, 300.dp),
                elevation = 4.dp
            ) {
                CoilImage(
                    data = photo,
                    contentDescription = stringResource(id = R.string.pet_image_content_description),
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}

@Composable
private fun PetDetailRow(titleId: Int, value: String) {
    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = stringResource(id = titleId), style = MaterialTheme.typography.h6)
        Text(
            text = value,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}
