package com.jjtelechea.satejuexample.di

import com.jjtelechea.satejuexample.domain.mapper.Mapper
import com.jjtelechea.satejuexample.domain.model.CharacterModel
import com.jjtelechea.satejuexample.domain.model.CharacterStatus
import com.jjtelechea.satejuexample.ui.mapper.CharacterMapper
import com.jjtelechea.satejuexample.ui.mapper.CharacterStatusMapper
import com.jjtelechea.satejuexample.ui.model.CharacterStatusUIModel
import com.jjtelechea.satejuexample.ui.model.CharacterUIModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindCharacterMapper(characterMapper: CharacterMapper): Mapper<CharacterModel, CharacterUIModel>

    @Binds
    abstract fun bindCharacterStatusMapper(characterStatusMapper: CharacterStatusMapper): Mapper<CharacterStatus, CharacterStatusUIModel>
}