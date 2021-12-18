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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.components.Preview
import io.github.ch8n.compose97.ui.theme.Black
import io.github.ch8n.compose97.ui.theme.Teal
import io.github.ch8n.compose97.ui.theme.White

data class DesktopItemProps(
    val iconResId: Int,
    val itemName: String
)

@Composable
fun DesktopItem(
    itemProps: DesktopItemProps,
    modifier: Modifier = Modifier,
    onItemClicked: (itemProps: DesktopItemProps) -> Unit
) {
    Column(
        modifier = modifier
            .clickable {
                onItemClicked.invoke(itemProps)
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = itemProps.iconResId),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = itemProps.itemName,
            style = MaterialTheme.typography.caption.copy(White),
            modifier = Modifier
                .border(1.dp, Black)
                .padding(2.dp)
                .background(Teal)
        )
    }
}

@Preview
@Composable
fun DesktopItemPreview() {
    Preview {
        DesktopItem(
            itemProps = DesktopItemProps(
                iconResId = R.drawable.my_computer_32x32,
                itemName = "My Computer",
            ),
            onItemClicked = {
            }
        )
    }
}
