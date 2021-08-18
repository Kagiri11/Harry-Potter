package com.example.harrypotter.repository


import com.example.harrypotter.data.local.CharacterCacheDao
import com.example.harrypotter.data.local.CharacterCacheEntity
import com.example.harrypotter.data.remote.CharacterNetworkEntity
import com.example.harrypotter.data.remote.PotterService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class PotterRepository
@Inject constructor(
    private val dbDao: CharacterCacheDao,
    private val networkService: PotterService
) {
    suspend fun fetchCharacters(): List<CharacterNetworkEntity> {
        return networkService.getStudents()
    }
    suspend fun getCharacters():List<CharacterCacheEntity>{
        return dbDao.getSavedCharacters()
    }
    suspend fun addFavouriteCharacter(character:CharacterCacheEntity)=dbDao.insertCharacter(character)

    suspend fun deleteCharacter(character:CharacterCacheEntity)=dbDao.deleteCharacter(character)
}