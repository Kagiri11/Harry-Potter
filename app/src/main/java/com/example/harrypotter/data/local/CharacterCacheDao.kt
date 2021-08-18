package com.example.harrypotter.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterCacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterCacheEntity)

    @Query("SELECT * FROM characters")
    suspend fun getSavedCharacters():List<CharacterCacheEntity>
}
