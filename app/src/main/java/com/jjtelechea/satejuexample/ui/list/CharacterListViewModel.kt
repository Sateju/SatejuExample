package com.jjtelechea.satejuexample.ui.list

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(
        listOf(
            CharacterModel(0, "Personaje 1"),
            CharacterModel(1, "Personaje 2"),
        )
    )
    val state = _state.asStateFlow()

    fun onItemClicked(id: Long) {
        println("Clicked $id")
    }
}