package com.mohamedfathidev.gymsnearby.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mohamedfathidev.gymsnearby.data.entity.GymLocalEntity
import com.mohamedfathidev.gymsnearby.data.entity.GymLocalFavoriteEntity

@Dao
interface GymDao {
    @Query("SELECT * FROM gyms")
    suspend fun getGyms(): List<GymLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGyms(gyms: List<GymLocalEntity>)

    @Update(entity = GymLocalEntity::class)
    suspend fun updateGym(gymLocalFavoriteEntity: GymLocalFavoriteEntity)

    @Query("SELECT * FROM gyms WHERE is_favorite = 1")
    suspend fun getFavoriteGyms(): List<GymLocalEntity>

    @Update(entity = GymLocalEntity::class)
    suspend fun updateAll(gymsFavoriteEntities: List<GymLocalFavoriteEntity>)
}