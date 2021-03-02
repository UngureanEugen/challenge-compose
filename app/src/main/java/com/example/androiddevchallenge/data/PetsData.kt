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
package com.example.androiddevchallenge.data

import androidx.compose.runtime.Immutable

@Immutable
data class Pet(
    val id: Int,
    val name: String,
    val description: String,
    val photos: List<String>,
    val breed: String = "",
    val color: String = "",
    val age: String = ""
)

object PetsData {
    val pets = listOf(
        Pet(
            1001,
            "Lucas",
            "Lucas was left in a balcony tied up and all because they had a baby and decided he would not be ok with their baby. He never dis anything wrong. After the trauma they caused Lucas would not allow a collar on his neck who could blame him. Good news we brought Luca to the best trainer in LA and Luca walks on a Kesha and wares the right gear. Lucas would love all the love he missed out in as a baby. Lucas would love to be your only dog, he has so much live to give. He loves to be loved he gets so happy when he is being petted and he loves his belly rubs. He is local to LA and sorry we don’t ship dogs out of state. He is truly incredible and deserves a loving experienced bully breed owner.",
            listOf(
                "https://pet-uploads.adoptapet.com/8/c/b/529177123.jpg",
                "https://pet-uploads.adoptapet.com/a/7/8/529177078.jpg",
                "https://pet-uploads.adoptapet.com/8/c/5/529177156.jpg"
            ),
            "English Bulldog", "White - with Tan, Yellow or Fawn", "  5 years old, Young"
        ),
        Pet(
            1002,
            "Sam",
            "Sam and Scout are sisters from other misters. Born from different litters, but came to our rescue weeks apart and have grown up together since they were just a few weeks old. Their bond is just as deep as true sisters are. Sam (the moo kitty) is a cuddle bug and loves to nuzzle in your neck. Scout is the class clown and always looking to be the center of attention and life of the party. These two play, eat, cuddle and groom each other all the time and Sam looks after her little sister like any big sister does. Both cats get along great with other cats and are litter box and scratching post trained. If you’re looking to fill your home with lots of love, these two girls are better than one.",
            listOf(
                "https://pet-uploads.adoptapet.com/d/a/b/408761775.jpg",
                "https://pet-uploads.adoptapet.com/2/4/2/408761783.jpg",
                "https://pet-uploads.adoptapet.com/a/2/e/408761792.jpg",
                "https://pet-uploads.adoptapet.com/3/e/7/408761800.jpg"
            ),
            "Domestic Shorthair", "Black & White or Tuxedo", "Young"
        ),
        Pet(
            1003,
            "Starlet",
            "Meet Starlet! This kitty has not had an easy life, but with your help, we hope to change all that. She was found recently, and needs a new home. Starlet is social and sweet, and is learning that she can have a wonderful new life with people who care. Her foster mom has been pampering this little angel! Would you like to pamper her too? NOTE: We are currently working with Starlet on a behavioral issue regarding litter box usage. We will let you know how things progress! In the meantime, she won't be attending our adoption events, unless applications are submitted to meet her.",
            listOf(
                "https://pet-uploads.adoptapet.com/3/0/b/352566760.jpg",
                "https://pet-uploads.adoptapet.com/2/4/c/352566766.jpg",
                "https://pet-uploads.adoptapet.com/3/a/b/352566772.jpg"
            ),
            "Persian", "Tortoiseshell", "Adult"
        ),
        Pet(
            1004,
            "Arnold",
            "It is highly likely that Arnold was used in skin studies, as pigs are often subjected to third degree burns and other skin testing experiments. Pigs are very intelligent and social animals that have been used in research for centuries. They are used in a wide variety of research studies, which includes biomedical and agricultural testing. Pigs are purposely bred for toxicology and pharmacology studies, transplantation studies, dermatological studies which include wound and injury healing, and even plastic surgery studies. ",
            listOf(
                "https://pet-uploads.adoptapet.com/3/e/0/422043586.jpg",
                "https://pet-uploads.adoptapet.com/8/e/b/422043606.jpg"
            ),
            "Pig (Potbellied)", "  ", "Adult"
        ),
    )
}
