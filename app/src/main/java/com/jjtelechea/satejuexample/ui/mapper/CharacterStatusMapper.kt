package com.jjtelechea.satejuexample.ui.mapper

import com.jjtelechea.satejuexample.domain.mapper.Mapper
import com.jjtelechea.satejuexample.domain.model.CharacterStatus
import com.jjtelechea.satejuexample.ui.model.CharacterStatusUIModel
import javax.inject.Inject

class CharacterStatusMapper @Inject constructor() : Mapper<CharacterStatus, CharacterStatusUIModel> {
    override fun map(input: CharacterStatus): CharacterStatusUIModel {
        return when (input) {
            CharacterStatus.ALIVE -> CharacterStatusUIModel.Alive
            CharacterStatus.DEAD -> CharacterStatusUIModel.Dead
            CharacterStatus.UNKNOWN -> CharacterStatusUIModel.Unknown
        }
    }
}