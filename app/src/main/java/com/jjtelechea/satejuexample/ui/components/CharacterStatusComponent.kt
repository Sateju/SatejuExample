package com.jjtelechea.satejuexample.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jjtelechea.satejuexample.ui.model.CharacterStatusUIModel
import com.jjtelechea.satejuexample.ui.theme.SatejuTheme

@Composable
fun CharacterStatusComponent(
    status: CharacterStatusUIModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = status.label)
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(status.color, CircleShape)
                .semantics { contentDescription = "Status: ${status.label}" }
        )
    }
}

@Preview
@Composable
private fun CharacterStatusComponentPreview() {
    SatejuTheme {
        CharacterStatusComponent(status = CharacterStatusUIModel.Alive)
    }
}