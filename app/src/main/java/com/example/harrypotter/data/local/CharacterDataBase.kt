package com.example.harrypotter.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CharacterCacheEntity::class],version = 1)
abstract class CharacterDataBase :RoomDatabase(){

    abstract fun dao():CharacterCacheDao

    companion object{
        val DB_NAME = "characters_db"
    }

}