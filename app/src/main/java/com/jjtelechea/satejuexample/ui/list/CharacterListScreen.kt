package com.jjtelechea.satejuexample.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jjtelechea.satejuexample.ui.components.CharacterComponent
import com.jjtelechea.satejuexample.ui.model.CharacterStatusUIModel
import com.jjtelechea.satejuexample.ui.model.CharacterUIModel
import com.jjtelechea.satejuexample.ui.theme.SatejuTheme

@Composable
fun ListScreen(
    viewModel: CharacterListViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        ListContent(
            state = state,
            onItemClicked = viewModel::onItemClicked,
            modifier = Modifier.padding(paddingValues)
        )
    }

}

@Composable
fun ListContent(
    state: List<CharacterUIModel>,
    onItemClicked: (id: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(state) { item ->
            CharacterComponent(
                model = item,
                onItemClicked = onItemClicked
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFFEFECEC)
@Composable
private fun ListScreenPreview() {
    val data = listOf(
        CharacterUIModel(
            1,
            "Rick Sanchez",
            "Human",
            "Citadel of Ricks",
            "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            CharacterStatusUIModel.Alive
        ),
        CharacterUIModel(
            2,
            "Morty Smith",
            "Human",
            "Citadel of Ricks",
            "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            CharacterStatusUIModel.Dead
        ),
        CharacterUIModel(
            3,
            "Summer Smith",
            "Human",
            "Earth (Replacement Dimension)",
            "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
            CharacterStatusUIModel.Unknown
        )
    )

    SatejuTheme {
        ListContent(state = data, {})
    }
}