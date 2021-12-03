package io.github.ch8n.compose97.ui.components.startbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.*


//private val startMenuItems = listOf(
//    StartMenuItemProps(R.drawable.my_computer_32x32, "My Computer"),
//    StartMenuItemProps(R.drawable.recycle_bin_32x32, "Recycle Bin"),
//    StartMenuItemProps(R.drawable.my_documents_folder_32x32, "My Documents"),
//    StartMenuItemProps(R.drawable.internet_explorer_32x32, "Internet Explorer"),
//    StartMenuItemProps(R.drawable.notepad_32x32, "Notepad"),
//)

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
                .fillMaxWidth(0.85f)
                .background(Silver)
                .align(Alignment.CenterEnd)
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

        Text(
            text = "Compose 97",
            style = MaterialTheme.typography.subtitle1.copy(color = White),
            modifier = Modifier
                .border(1.dp, Color.Green)
                .rotate(-90f)

        )
    }
}


@Preview
@Composable
fun StartMenuPreview() {
    Compose97Theme {
        StartMenu(
            modifier = Modifier.fillMaxWidth(0.5f),
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