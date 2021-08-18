package com.example.harrypotter.data.local

import androidx.room.Entity
import com.example.harrypotter.models.Wand

@Entity(tableName = "characters")
data class CharacterCacheEntity(
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