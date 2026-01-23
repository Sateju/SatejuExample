package com.jjtelechea.satejuexample.ui.model

import androidx.compose.ui.graphics.Color

sealed class CharacterStatusUIModel(
    val label: String,
    val color: Color
) {
    data object Alive : CharacterStatusUIModel("Alive", Color.Green)
    data object Dead : CharacterStatusUIModel("Dead", Color.Red)
    data object Unknown : CharacterStatusUIModel("Unknown", Color.Gray)
}