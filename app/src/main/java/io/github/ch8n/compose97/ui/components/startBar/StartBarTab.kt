package io.github.ch8n.compose97.ui.components.startBar

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.Gray

data class StartTabProps(
    val name: String,
    val iconRes: Int,
    val onClickTab: () -> Unit
)

@Preview
@Composable
fun StarBarTabPreview() {
    io.github.ch8n.compose97.ui.components.Preview {
        StartBarTab(
            modifier = Modifier.width(100.dp),
            props = StartTabProps(
                name = "Start",
                iconRes = R.drawable.ic_windows95,
                onClickTab = {

                }
            )
        )
    }
}

@Composable
fun StartBarTab(
    props: StartTabProps,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(1.dp, Gray)
            .padding(4.dp)
            .clickable(onClick = props.onClickTab),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = props.iconRes),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = props.name,
                style = MaterialTheme.typography.button
            )
        }
    }
}