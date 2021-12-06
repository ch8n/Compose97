package io.github.ch8n.compose97.ui.components.startBar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.Gray
import io.github.ch8n.compose97.ui.theme.Silver

data class StartBarProps(
    val onStartButtonClicked: () -> Unit,
    val tabs: List<StartTabProps>
)

@Composable
fun StartBar(
    modifier: Modifier,
    props: StartBarProps
) {
    LazyRow(
        modifier = modifier
            .border(width = 1.dp, color = Gray)
            .background(Silver),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            Spacer(modifier = Modifier.width(4.dp))

            StartBarTab(
                modifier = Modifier
                    .width(100.dp)
                    .height(42.dp),
                props = StartTabProps(
                    name = "Start",
                    iconRes = R.drawable.ic_windows95,
                    onClickTab = props.onStartButtonClicked
                )
            )
        }
        item {
            Surface(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight(0.8f),
                elevation = 4.dp,
                color = Gray
            ) {}
        }
        items(props.tabs) { tab ->
            StartBarTab(
                modifier = Modifier
                    .width(180.dp)
                    .height(42.dp),
                props = StartTabProps(
                    name = tab.name,
                    iconRes = tab.iconRes,
                    onClickTab = tab.onClickTab
                )
            )
        }
    }
}

@Preview
@Composable
fun StartBarPreview() {
    StartBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        props = StartBarProps(
            tabs = listOf(
                StartTabProps(
                    name = "My Computer",
                    iconRes = R.drawable.my_computer_32x32,
                    onClickTab = {
                    }
                )
            ),
            onStartButtonClicked = {}
        )
    )
}
