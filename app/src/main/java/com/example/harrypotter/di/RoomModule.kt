package com.example.harrypotter.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.harrypotter.data.local.CharacterCacheDao
import com.example.harrypotter.data.local.CharacterDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun giveMeCharacterDB(@ApplicationContext context: Context):CharacterDataBase{
        return Room.databaseBuilder(context,CharacterDataBase::class.java,CharacterDataBase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun giveMeCharacterDBDao(dataBase: CharacterDataBase):CharacterCacheDao{
        return dataBase.dao()
    }
}