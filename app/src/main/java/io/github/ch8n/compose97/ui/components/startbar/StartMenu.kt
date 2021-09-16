package io.github.ch8n.compose97.ui.components.startbar

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
import io.github.ch8n.compose97.ui.theme.Compose97Theme
import io.github.ch8n.compose97.ui.theme.Gray
import io.github.ch8n.compose97.ui.theme.Silver
import io.github.ch8n.compose97.ui.theme.White


private val startMenuItems = listOf(
    StartMenuItemState(R.drawable.my_computer_32x32, "My Computer"),
    StartMenuItemState(R.drawable.recycle_bin_32x32, "Recycle Bin"),
    StartMenuItemState(R.drawable.my_documents_folder_32x32, "My Documents"),
    StartMenuItemState(R.drawable.internet_explorer_32x32, "Internet Explorer"),
    StartMenuItemState(R.drawable.notepad_32x32, "Notepad"),
)

@Composable
fun StartMenu() {
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
            startMenuItems.forEachIndexed { index, item ->
                val itemState = remember { mutableStateOf(item) }
                StartMenuItem(
                    state = itemState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .wrapContentHeight(),
                    onItemClick = {
                        // todo stuff...
                    }
                )
                if (index != startMenuItems.lastIndex) {
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
fun StartMenuPreview() {
    Compose97Theme {
        StartMenu()
    }
}