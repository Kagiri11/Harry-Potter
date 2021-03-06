package com.example.harrypotter.models

import java.io.Serializable

/**
 * Please consider this as the central domain model for characters...Doesn't change..
 */
data class Character(
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
    val yearOfBirth: String
):Serializable