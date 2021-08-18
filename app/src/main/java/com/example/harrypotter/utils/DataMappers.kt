package com.example.harrypotter.utils

/**
 * This interface takes in one type of entity and gives us the other
 * say you give it a model (in this case either the students or the staff model),
 * it will provide you with an entity of the same
 * An entity is just a twin of the domain model but it now comes from a source
 */
interface DataMappers <Entity, Model>{

    fun mapFromEntityToModel(entity: Entity):Model

    fun mapFromModelToEntity(model: Model):Entity
}