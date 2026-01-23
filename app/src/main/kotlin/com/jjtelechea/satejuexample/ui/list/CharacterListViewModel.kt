package com.jjtelechea.satejuexample.ui.list

import androidx.lifecycle.ViewModel
import com.jjtelechea.satejuexample.domain.mapper.Mapper
import com.jjtelechea.satejuexample.domain.model.CharacterModel
import com.jjtelechea.satejuexample.domain.model.CharacterStatus
import com.jjtelechea.satejuexample.ui.model.CharacterUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    characterMapper: Mapper<CharacterModel, CharacterUIModel>
) : ViewModel() {

    val data = listOf(
        CharacterModel(
            1,
            "Rick Sanchez",
            "Human",
            "Citadel of Ricks",
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            CharacterStatus.ALIVE
        ),
        CharacterModel(
            2,
            "Morty Smith",
            "Human",
            "Citadel of Ricks",
            "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            CharacterStatus.DEAD
        ),
        CharacterModel(
            3,
            "Summer Smith",
            "Human",
            "Earth (Replacement Dimension)",
            "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
            CharacterStatus.UNKNOWN
        )
    )

    private val _state = MutableStateFlow(data.map { characterMapper.map(it) })
    val state = _state.asStateFlow()

    fun onItemClicked(id: Long) {
        println("Clicked $id")
    }
}