package io.github.ch8n.compose97.ui.components.startMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.*

@Composable
fun StartMenu(
    modifier: Modifier = Modifier,
    menuItems: List<StartMenuItemProps>
) {
    Box(
        modifier = modifier
            .border(width = 1.dp, color = White)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Navy,
                        RoyalBlue
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .background(Silver)
                .fillMaxWidth(0.88f)
                .align(Alignment.TopEnd)
        ) {
            menuItems.forEachIndexed { index, item ->
                StartMenuItem(
                    props = item,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                if (index != menuItems.lastIndex) {
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
        StartMenu(
            modifier = Modifier.fillMaxWidth(0.65f),
            menuItems = listOf(
                StartMenuItemProps(
                    iconId = R.drawable.my_computer_32x32,
                    name = "My Computer",
                    onItemClick = {}
                ),
                StartMenuItemProps(
                    iconId = R.drawable.recycle_bin_32x32,
                    name = "Recycle Bin",
                    onItemClick = {}
                ),
                StartMenuItemProps(
                    iconId = R.drawable.my_documents_folder_32x32,
                    name = "My Documents",
                    onItemClick = {}
                ),
                StartMenuItemProps(
                    iconId = R.drawable.internet_explorer_32x32,
                    name = "Internet Explorer",
                    onItemClick = {}
                ),
                StartMenuItemProps(
                    iconId = R.drawable.notepad_32x32,
                    name = "Notepad",
                    onItemClick = {}
                ),
            )
        )
    }
}
