package com.jjtelechea.satejuexample.domain.model

data class CharacterModel(
    val id: Long,
    val name: String,
    val species: String,
    val location: String,
    val image: String,
    val status: CharacterStatus
)


