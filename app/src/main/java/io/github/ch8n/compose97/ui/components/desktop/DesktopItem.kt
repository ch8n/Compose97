package io.github.ch8n.compose97.ui.components.desktop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.components.Preview

data class DesktopItemProps(
    val iconResId: Int,
    val itemName: String,
    val onItemClicked: () -> Unit
)

@Composable
fun DesktopItem(
    itemProps: DesktopItemProps,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clickable(
                onClick = itemProps.onItemClicked
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = itemProps.iconResId),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.size(28.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = itemProps.itemName,
            style = MaterialTheme.typography.h1
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
                onItemClicked = {

                }
            )
        )
    }
}