package com.example.harrypotter.data.local

import androidx.room.*

@Dao
interface CharacterCacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterCacheEntity)

    @Query("SELECT * FROM characters")
    suspend fun getSavedCharacters():List<CharacterCacheEntity>

    @Delete
    suspend fun deleteCharacter(character: CharacterCacheEntity)
}
