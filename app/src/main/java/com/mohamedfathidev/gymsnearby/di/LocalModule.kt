package com.mohamedfathidev.gymsnearby.di

import android.content.Context
import androidx.room.Room
import com.mohamedfathidev.gymsnearby.data.entity.GymLocalEntity
import com.mohamedfathidev.gymsnearby.data.entity.GymLocalFavoriteEntity
import com.mohamedfathidev.gymsnearby.data.local.GymDao
import com.mohamedfathidev.gymsnearby.data.local.GymDatabase
import com.mohamedfathidev.gymsnearby.data.mapper.LocalFavoriteMapper
import com.mohamedfathidev.gymsnearby.data.mapper.LocalMapper
import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.entity.GymFavoriteState
import com.mohamedfathidev.gymsnearby.domain.util.Constant.DatabaseName
import com.mohamedfathidev.gymsnearby.domain.util.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideLocalMapper(): EntityMapper<GymLocalEntity, Gym> {
        return LocalMapper()
    }

    @Singleton
    @Provides
    fun provideLocalFavoriteMapper(): EntityMapper<GymLocalFavoriteEntity, GymFavoriteState> {
        return LocalFavoriteMapper()
    }

    @Singleton
    @Provides
    fun provideGymsDatabase(@ApplicationContext context: Context): GymDatabase {
        return Room
            .databaseBuilder(
                context,
                GymDatabase::class.java,
                DatabaseName
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideGymsDao(gymsDatabase: GymDatabase): GymDao {
        return gymsDatabase.gymDao()
    }


}