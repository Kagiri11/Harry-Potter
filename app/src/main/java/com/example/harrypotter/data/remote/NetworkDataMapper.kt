package com.example.harrypotter.data.remote

import com.example.harrypotter.models.Character
import com.example.harrypotter.utils.DataMappers

class NetworkDataMapper : DataMappers<CharacterNetworkEntity, Character> {
    override fun mapFromEntityToModel(entity: CharacterNetworkEntity): Character {
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
            wand = entity.wand,
            yearOfBirth = entity.yearOfBirth
        )
    }

    override fun mapFromModelToEntity(model: Character): CharacterNetworkEntity {
        return CharacterNetworkEntity(
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
            wand = model.wand,
            yearOfBirth = model.yearOfBirth
        )
    }

    fun createListFromEntityList(entities : List<CharacterNetworkEntity>): List<Character>{
        return entities.map { networkEntity->
            mapFromEntityToModel(networkEntity)
        }
    }
}