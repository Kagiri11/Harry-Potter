package com.example.harrypotter.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.harrypotter.models.Wand

@Entity(tableName = "characters")
data class CharacterCacheEntity(
    @PrimaryKey(autoGenerate = false)
    val name: String,
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
    val patronus: String,
    val species: String,
    val yearOfBirth: String
)