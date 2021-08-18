package com.example.harrypotter.repository


import com.example.harrypotter.data.local.CharacterCacheDao
import com.example.harrypotter.data.local.CharacterCacheEntity
import com.example.harrypotter.data.remote.CharacterNetworkEntity
import com.example.harrypotter.data.remote.PotterService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class PotterRepository
@Inject constructor(
    val dbDao: CharacterCacheDao,
    val networkService: PotterService
) {
    suspend fun fetchCharacters(): List<CharacterNetworkEntity> {
        return networkService.getStudents()
    }
    suspend fun getCharacters():List<CharacterCacheEntity>{
        return dbDao.getSavedCharacters()
    }
    suspend fun addFavouriteCharacter(character:CharacterCacheEntity)=dbDao.insertCharacter(character)
}