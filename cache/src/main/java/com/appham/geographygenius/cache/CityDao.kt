package com.appham.geographygenius.cache

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface CityDao {

    @Query("SELECT * FROM cityentity")
    suspend fun getAll(): List<CityEntity>

    @Update
    suspend fun updateAll(vararg cities: CityEntity)
}