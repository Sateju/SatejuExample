package com.jjtelechea.satejuexample.di

import android.content.Context
import androidx.room.Room
import com.jjtelechea.satejuexample.data.local.SatejuDatabase
import com.jjtelechea.satejuexample.data.local.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "sateju_database"

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SatejuDatabase =
        Room.databaseBuilder(
            context,
            SatejuDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Provides
    fun provideCharacterDao(db: SatejuDatabase): CharacterDao = db.characterDao()

}