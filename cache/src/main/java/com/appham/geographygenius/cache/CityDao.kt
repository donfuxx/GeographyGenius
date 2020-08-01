package com.appham.geographygenius.cache

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CityDao {
    @Query("SELECT * FROM cityentity")
    suspend fun getAll(): List<CityEntity>
}