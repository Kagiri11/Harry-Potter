package com.example.harrypotter.data.remote

import com.example.harrypotter.models.Wand

data class CharacterNetworkEntity(
    //The person who created the API named these fields pretty well so we dont
    //have to use the @Serialized notation
    val actor: String,
    val alive: Boolean,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wand: Wand,
    val yearOfBirth: String
)