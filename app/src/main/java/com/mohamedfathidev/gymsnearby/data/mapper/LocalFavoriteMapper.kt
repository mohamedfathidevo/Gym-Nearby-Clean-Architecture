package com.mohamedfathidev.gymsnearby.data.mapper

import com.mohamedfathidev.gymsnearby.data.entity.GymLocalFavoriteEntity
import com.mohamedfathidev.gymsnearby.domain.entity.GymFavoriteState
import com.mohamedfathidev.gymsnearby.domain.util.EntityMapper
import javax.inject.Inject

class LocalFavoriteMapper
@Inject constructor() : EntityMapper<GymLocalFavoriteEntity, GymFavoriteState> {
    override fun mapFromEntity(entity: GymLocalFavoriteEntity): GymFavoriteState {
        return GymFavoriteState(
            id = entity.id,
            isFavorite = entity.isFavorite
        )
    }

    override fun mapToEntity(domainModel: GymFavoriteState): GymLocalFavoriteEntity {
        return GymLocalFavoriteEntity(
            id = domainModel.id,
            isFavorite = domainModel.isFavorite
        )
    }

    fun mapFromEntityList(entities: List<GymLocalFavoriteEntity>): List<GymFavoriteState> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(entities: List<GymFavoriteState>): List<GymLocalFavoriteEntity> {
        return entities.map { mapToEntity(it) }
    }

}