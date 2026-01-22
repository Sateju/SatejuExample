package com.jjtelechea.satejuexample.ui.mapper

import com.jjtelechea.satejuexample.domain.mapper.Mapper
import com.jjtelechea.satejuexample.domain.model.CharacterModel
import com.jjtelechea.satejuexample.domain.model.CharacterStatus
import com.jjtelechea.satejuexample.ui.model.CharacterStatusUIModel
import com.jjtelechea.satejuexample.ui.model.CharacterUIModel
import javax.inject.Inject

class CharacterMapper @Inject constructor(
    private val characterStatusMapper: Mapper<CharacterStatus, CharacterStatusUIModel>
) : Mapper<CharacterModel, CharacterUIModel> {
    override fun map(input: CharacterModel): CharacterUIModel {
        return CharacterUIModel(
            id = input.id,
            name = input.name,
            species = input.species,
            location = input.location,
            image = input.image,
            status = characterStatusMapper.map(input.status)
        )
    }
}