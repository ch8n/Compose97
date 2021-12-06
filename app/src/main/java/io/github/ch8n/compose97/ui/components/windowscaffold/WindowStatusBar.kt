package io.github.ch8n.compose97.ui.components.windowscaffold

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.*

data class StatusBarProps(
    val title: String,
    @DrawableRes val mainIcon: Int,
    val onMinimiseClicked: () -> Unit,
    val onMaximiseClicked: () -> Unit,
    val onCloseClicked: () -> Unit,
)

@Composable
fun WindowStatusBar(
    props: StatusBarProps,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Navy,
                        RoyalBlue
                    )
                )
            )
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = props.mainIcon),
                modifier = Modifier.size(16.dp),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = props.title, color = White, fontWeight = FontWeight.SemiBold)
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_mini_toolbar),
                modifier = Modifier
                    .size(16.dp)
                    .border(1.dp, Black)
                    .background(Silver)
                    .padding(4.dp)
                    .clickable(onClick = props.onMinimiseClicked),
                contentDescription = null,
                tint = Black
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_maxi_toolbar),
                modifier = Modifier
                    .size(16.dp)
                    .border(1.dp, Black)
                    .background(Silver)
                    .padding(4.dp)
                    .clickable(onClick = props.onMaximiseClicked),
                contentDescription = null,
                tint = Black
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_close_toolbar),
                modifier = Modifier
                    .size(16.dp)
                    .border(1.dp, Black)
                    .background(Silver)
                    .padding(4.dp)
                    .clickable(onClick = props.onCloseClicked),
                contentDescription = null,
                tint = Black
            )
        }
    }
}
