package io.github.ch8n.compose97.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.components.startbar.StartBarItem
import io.github.ch8n.compose97.ui.components.startbar.StartBarItemState
import io.github.ch8n.compose97.ui.theme.Compose97Theme
import io.github.ch8n.compose97.ui.theme.Gray
import io.github.ch8n.compose97.ui.theme.Silver
import io.github.ch8n.compose97.ui.theme.White


val startBarItems = listOf(
    StartBarItemState(R.drawable.my_computer_32x32, "My Computer"),
    StartBarItemState(R.drawable.recycle_bin_32x32, "Recycle Bin"),
    StartBarItemState(R.drawable.my_documents_folder_32x32, "My Documents"),
    StartBarItemState(R.drawable.internet_explorer_32x32, "Internet Explorer"),
    StartBarItemState(R.drawable.notepad_32x32, "Notepad"),
)

@Composable
fun StartBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .wrapContentHeight()
            .border(width = 1.dp,color = White)
            .background(Silver)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            startBarItems.forEachIndexed { index, item ->
                val itemState = remember { mutableStateOf(item) }
                StartBarItem(
                    state = itemState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentHeight(),
                    onItemClick = {
                        // todo stuff...
                    }
                )
                if (index != startBarItems.lastIndex) {
                    Divider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Gray
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun StartBarPreview() {
    Compose97Theme {
        StartBar()
    }
}