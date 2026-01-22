package com.jjtelechea.satejuexample.ui.model

data class CharacterUIModel(
    val id: Long,
    val name: String,
    val species: String,
    val location: String,
    val image: String,
    val status: CharacterStatusUIModel
)
