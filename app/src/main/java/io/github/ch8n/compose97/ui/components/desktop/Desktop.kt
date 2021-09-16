package io.github.ch8n.compose97.ui.components.desktop

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R


private val desktopItems = listOf(
    DesktopItemState(R.drawable.my_computer_32x32, "My Computer"),
    DesktopItemState(R.drawable.recycle_bin_32x32, "Recycle Bin"),
    DesktopItemState(R.drawable.my_documents_folder_32x32, "My Documents"),
    DesktopItemState(R.drawable.internet_explorer_32x32, "Internet\nExplorer"),
    DesktopItemState(R.drawable.notepad_32x32, "Notepad"),
)

@Composable
fun Desktop(){
    Box(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            desktopItems.forEachIndexed { index, item ->
                val itemState = remember { mutableStateOf(item) }
                DesktopItem(
                    state = itemState,
                    modifier = Modifier
                        .padding(16.dp),
                    onItemClick = {
                        // todo stuff...
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun DesktopPreview(){
    Desktop()
}