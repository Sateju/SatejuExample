package com.jjtelechea.satejuexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jjtelechea.satejuexample.data.local.converters.EpisodeIdsConverter
import com.jjtelechea.satejuexample.data.local.dao.CharacterDao
import com.jjtelechea.satejuexample.data.local.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(EpisodeIdsConverter::class)
abstract class SatejuDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}