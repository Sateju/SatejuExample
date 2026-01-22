package com.jjtelechea.satejuexample.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jjtelechea.satejuexample.ui.model.CharacterStatusUIModel
import com.jjtelechea.satejuexample.ui.model.CharacterUIModel
import com.jjtelechea.satejuexample.ui.theme.SatejuTheme

@Composable
fun CharacterComponent(
    model: CharacterUIModel,
    onItemClicked: (id: Long) -> Unit,
    modifier: Modifier = Modifier
) {
    ListItem(
        modifier = modifier.clickable { onItemClicked(model.id) },
        headlineContent = { Text(model.name) },
        overlineContent = { Text(model.species) },
        supportingContent = { Text(model.location) },
        trailingContent = { CharacterStatusComponent(model.status) },
        leadingContent = {
            AsyncImage(
                model = model.image,
                contentDescription = model.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )
        }
    )
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFFEFECEC)
@Composable
private fun CharacterComponentPreview() {
    val model = CharacterUIModel(
        1,
        "Rick Sanchez",
        "Human",
        "Citadel of Ricks",
        "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
        CharacterStatusUIModel.Alive
    )

    SatejuTheme {
        CharacterComponent(model, {})
    }
}