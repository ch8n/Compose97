package io.github.ch8n.compose97.routes.desktop

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.routes.window97.Window97Common
import io.github.ch8n.compose97.ui.theme.Black
import io.github.ch8n.compose97.ui.theme.Teal
import io.github.ch8n.compose97.ui.theme.White

data class DesktopItemProps(
    val iconResId: Int,
    val itemName: String
)

@Composable
fun DesktopItem(
    window97Common: Window97Common,
    modifier: Modifier = Modifier,
    onItemClicked: (window97Common: Window97Common) -> Unit
) {
    Column(
        modifier = modifier
            .clickable {
                onItemClicked.invoke(window97Common)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = window97Common.iconId),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = window97Common.label,
            style = MaterialTheme.typography.caption.copy(White),
            modifier = Modifier
                .border(1.dp, Black)
                .padding(2.dp)
                .background(Teal)
        )
    }
}