package com.appham.geographygenius.cache

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.appham.geographygenius.domain.entities.DbPlacesDataSource
import org.koin.dsl.module

val cacheModule = module {
    single { Room.databaseBuilder(
        get(),
        CityDatabase::class.java, "cities-db"
    ).build() }
    single {
        get<CityDatabase>().cityDao()
    }
    single<DbPlacesDataSource> {
        LocalPlacesDataSource(get())
    }
}

@Database(entities = [CityEntity::class], version = 1)
abstract class CityDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}