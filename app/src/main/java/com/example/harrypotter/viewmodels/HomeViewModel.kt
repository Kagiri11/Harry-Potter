package com.example.harrypotter.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.harrypotter.data.local.CacheDataMapper
import com.example.harrypotter.data.local.CharacterCacheEntity
import com.example.harrypotter.data.remote.CharacterNetworkEntity
import com.example.harrypotter.data.remote.NetworkDataMapper
import com.example.harrypotter.data.repository.PotterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(val repo: PotterRepository
): ViewModel() {

    val dbCharacters = liveData{
        emit(repo.getCharacters())
    }

    val netCharacters = liveData {
        emit(repo.fetchCharacters())
    }

    suspend fun addFavouriteCharacter(characterNetworkEntity: CharacterNetworkEntity){
        val model = NetworkDataMapper().mapFromEntityToModel(characterNetworkEntity)
        val cache = CacheDataMapper().mapFromModelToEntity(model)
        repo.addFavouriteCharacter(cache)
    }

    suspend fun deleteCharacter(characterCacheEntity: CharacterCacheEntity){
        repo.deleteCharacter(characterCacheEntity)
    }

}