package io.github.ch8n.compose97.ui.components.startMenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.Compose97Theme

data class StartMenuItemProps(
    val iconId: Int,
    val name: String,
    val onItemClick: () -> Unit
)

@Composable
fun StartMenuItem(
    modifier: Modifier,
    props: StartMenuItemProps
) {
    Row(
        modifier = modifier
            .clickable(onClick = props.onItemClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = props.iconId),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.size(width = 28.dp, height = 28.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = props.name)
    }
}

@Preview
@Composable
fun StartMenuItemPreview() {
    Compose97Theme {
        StartMenuItem(
            props = StartMenuItemProps(
                iconId = R.drawable.my_computer_32x32,
                name = "My Computer",
                onItemClick = {}
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}
