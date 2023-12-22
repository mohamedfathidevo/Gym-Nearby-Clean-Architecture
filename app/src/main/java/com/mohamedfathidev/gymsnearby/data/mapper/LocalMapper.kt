package com.mohamedfathidev.gymsnearby.data.mapper

import com.mohamedfathidev.gymsnearby.data.entity.GymLocalEntity
import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.util.EntityMapper
import javax.inject.Inject

class LocalMapper
@Inject constructor() : EntityMapper<GymLocalEntity, Gym> {
    override fun mapFromEntity(entity: GymLocalEntity): Gym {
        return Gym(
            id = entity.id,
            gymName = entity.gymName,
            gymLocation = entity.gymLocation,
            isOpen = entity.isOpen,
            isFavorite = entity.isFavorite
        )
    }

    override fun mapToEntity(domainModel: Gym): GymLocalEntity {
        return GymLocalEntity(
            id = domainModel.id,
            gymName = domainModel.gymName,
            gymLocation = domainModel.gymLocation,
            isOpen = domainModel.isOpen,
            isFavorite = domainModel.isFavorite
        )
    }

    fun mapFromEntityList(entities: List<GymLocalEntity>): List<Gym> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(entities: List<Gym>): List<GymLocalEntity> {
        return entities.map { mapToEntity(it) }
    }

}