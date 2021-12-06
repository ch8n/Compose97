package io.github.ch8n.compose97.ui.components.windowscaffold

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
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
import io.github.ch8n.compose97.ui.theme.Gray
import io.github.ch8n.compose97.ui.theme.Silver

data class NavToolbarProp(
    val name: String,
    @DrawableRes val iconRes: Int,
    val onOptionClicked: () -> Unit,
    val isExtra: Boolean = false,
)

@Composable
fun WindowNavToolbar(
    modifier: Modifier,
    toolbarOptions: List<NavToolbarProp>
) {
    Row(
        modifier = modifier
            .background(Silver)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        val (extraItems, navItems) = toolbarOptions.partition { it.isExtra }

        navItems.forEach {
            NavButton(
                modifier = Modifier,
                iconRes = it.iconRes,
                label = it.name,
                onClick = it.onOptionClicked
            )
        }

        Divider(
            modifier = Modifier
                .height(18.dp)
                .width(1.dp),
            color = Gray,
        )

        extraItems.forEach {
            NavButton(
                modifier = Modifier,
                iconRes = it.iconRes,
                label = it.name,
                onClick = it.onOptionClicked
            )
        }

    }
}

@Composable
fun NavButton(
    modifier: Modifier,
    @DrawableRes iconRes: Int,
    label: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.DarkGray
        )

        Text(
            text = label,
            style = MaterialTheme.typography.caption,
        )

    }
}

@Preview
@Composable
fun WindowNavToolbarPreview() {
    io.github.ch8n.compose97.ui.components.Preview {
        WindowNavToolbar(
            modifier = Modifier.fillMaxWidth(),
            toolbarOptions = listOf(
                NavToolbarProp(
                    name = "Back",
                    iconRes = R.drawable.ic_back_navtool,
                    onOptionClicked = {}
                ),
                NavToolbarProp(
                    name = "Forward",
                    iconRes = R.drawable.ic_forward_navtool,
                    onOptionClicked = {}
                ),
                NavToolbarProp(
                    name = "Up",
                    iconRes = R.drawable.ic_up_navtool,
                    onOptionClicked = {}
                ),
                NavToolbarProp(
                    name = "Delete",
                    iconRes = R.drawable.ic_delete_navtool,
                    isExtra = true,
                    onOptionClicked = {}
                ),
            ),
        )
    }
}