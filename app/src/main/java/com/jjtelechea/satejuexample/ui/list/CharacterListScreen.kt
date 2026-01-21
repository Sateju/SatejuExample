package com.jjtelechea.satejuexample.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    state: List<CharacterModel>,
    onItemClicked: (id: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(state) { item ->
            ListItem(
                modifier = Modifier.clickable { onItemClicked(item.id) },
                headlineContent = { Text(item.name) },
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFFEFECEC)
@Composable
private fun ListScreenPreview() {
    SatejuTheme {
        ListScreen()
    }
}