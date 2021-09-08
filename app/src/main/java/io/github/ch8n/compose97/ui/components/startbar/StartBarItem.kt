package io.github.ch8n.compose97.ui.components.startbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.Compose97Theme

data class StartBarItemState(
    val iconId: Int,
    val name: String
)

@Composable
fun StartBarItem(
    state: State<StartBarItemState>,
    modifier: Modifier,
    onItemClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .clickable {
                onItemClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = state.value.iconId),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.size(width = 28.dp, height = 28.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = state.value.name)
    }
}


@Preview
@Composable
fun StartBarItemPreview() {
    Compose97Theme {
        val state = StartBarItemState(
            iconId = R.drawable.my_computer_32x32,
            name = "My Computer",
        )
        StartBarItem(
            state = remember { mutableStateOf(state) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentHeight(),
            onItemClick = {

            }
        )
    }
}