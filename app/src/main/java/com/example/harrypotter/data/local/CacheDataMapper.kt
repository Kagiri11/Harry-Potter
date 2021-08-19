package com.example.harrypotter.data.local

import com.example.harrypotter.data.remote.CharacterNetworkEntity
import com.example.harrypotter.models.Character
import com.example.harrypotter.utils.DataMappers

class CacheDataMapper : DataMappers<CharacterCacheEntity,Character> {
    override fun mapFromEntityToModel(entity: CharacterCacheEntity): Character {
        return Character(
            actor = entity.actor,
            alive = entity.alive,
            ancestry = entity.ancestry,
            dateOfBirth = entity.dateOfBirth,
            eyeColour = entity.eyeColour,
            gender = entity.gender,
            hairColour = entity.hairColour,
            hogwartsStaff = entity.hogwartsStaff,
            hogwartsStudent = entity.hogwartsStudent,
            house = entity.house,
            image = entity.image,
            name = entity.name,
            patronus = entity.patronus,
            species = entity.species,
            yearOfBirth = entity.yearOfBirth,
        )
    }

    override fun mapFromModelToEntity(model: Character): CharacterCacheEntity {
        return CharacterCacheEntity(
            actor = model.actor,
            alive = model.alive,
            ancestry = model.ancestry,
            dateOfBirth = model.dateOfBirth,
            eyeColour = model.eyeColour,
            gender = model.gender,
            hairColour = model.hairColour,
            hogwartsStaff = model.hogwartsStaff,
            hogwartsStudent = model.hogwartsStudent,
            house = model.house,
            image = model.image,
            name = model.name,
            patronus = model.patronus,
            species = model.species,
            yearOfBirth = model.yearOfBirth,
        )
    }

    fun createListFromEntityList(entities : List<CharacterCacheEntity>): List<Character>{
        return entities.map { cacheEntity->
            mapFromEntityToModel(cacheEntity)
        }
    }
}