package com.mohamedfathidev.gymsnearby.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohamedfathidev.gymsnearby.data.entity.GymLocalEntity

@Database(
    entities = [GymLocalEntity::class],
    version = 3,
    exportSchema = false
)
abstract class GymDatabase : RoomDatabase() {
    abstract fun gymDao(): GymDao
}