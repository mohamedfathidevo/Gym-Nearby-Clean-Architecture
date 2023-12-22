package com.mohamedfathidev.gymsnearby.data.mapper

import com.mohamedfathidev.gymsnearby.data.entity.GymNetworkEntity
import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject constructor() : EntityMapper<GymNetworkEntity, Gym> {
    override fun mapFromEntity(entity: GymNetworkEntity): Gym {
        return Gym(
            id = entity.id,
            gymName = entity.gymName,
            gymLocation = entity.gymLocation,
            isOpen = entity.isOpen
        )
    }

    override fun mapToEntity(domainModel: Gym): GymNetworkEntity {
        return GymNetworkEntity(
            id = domainModel.id,
            gymName = domainModel.gymName,
            gymLocation = domainModel.gymLocation,
            isOpen = domainModel.isOpen
        )
    }

    fun mapFromEntityList(entities: List<GymNetworkEntity>): List<Gym> {
        return entities.map { mapFromEntity(it) }
    }

}