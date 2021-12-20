package io.github.ch8n.compose97.routes.recyclebin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.navigation.DecomposeComponent
import io.github.ch8n.compose97.navigation.NavigationComponent
import io.github.ch8n.compose97.routes.window97.Window97Common
import io.github.ch8n.compose97.ui.components.windowscaffold.StatusBarProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowAddressProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowScaffold

class RecycleBinComponent(
    componentContext: ComponentContext,
) : DecomposeComponent(componentContext) {

    val recycleBin = Window97Common.RecyclerBin

    val statusBar = StatusBarProps(
        title = recycleBin.label,
        mainIcon = recycleBin.iconId
    )

    val windowProps = WindowAddressProps(
        iconRes = recycleBin.iconId,
        name = recycleBin.label,
        path = "~RecycleBin://"
    )

    fun getDeletedFolders(): List<String> {
        return mutableListOf<String>().apply {
            repeat(10) {
                add("folder${it + 1}")
            }
        }
    }

    fun getDeletedFiles(): List<String> {
        return mutableListOf<String>().apply {
            repeat(10) {
                add("files${it + 1}")
            }
        }
    }

    fun onMinimiseClicked() {}
    fun onMaximiseClicked() {}
    fun onCloseClicked() {}
    fun onRestore(folderOrFileName: String) {
    }

    fun onPermanentDelete(folderOrFileName: String) {
    }
}

@Composable
fun RecycleBin(
    recycleBinComponent: RecycleBinComponent,
    navComponent: NavigationComponent,
) {
    val recycleBinWindowProps = remember {
        WindowProps(
            statusBar = recycleBinComponent.statusBar,
            toolbar = emptyList(),
            navToolbar = emptyList(),
            addressBar = recycleBinComponent.windowProps,
            isMaximised = true
        )
    }

    WindowScaffold(
        props = recycleBinWindowProps,
        onMinimiseClicked = recycleBinComponent::onMinimiseClicked,
        onMaximiseClicked = recycleBinComponent::onMaximiseClicked,
        onCloseClicked = recycleBinComponent::onCloseClicked
    ) {
        val deletedItems =
            recycleBinComponent.getDeletedFiles() + recycleBinComponent.getDeletedFolders()

        var isDeleteDialogShown by remember { mutableStateOf(false to "") }

        if (isDeleteDialogShown.first) {
            // TODO make styles of dialog box
            AlertDialog(
                onDismissRequest = {
                    isDeleteDialogShown = isDeleteDialogShown.copy(first = false)
                },
                title = {
                    Text(text = "You want to restore the item?")
                },
                text = {
                    Column() {
                    }
                },
                buttons = {
                    Row(
                        modifier = Modifier.padding(all = 8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                isDeleteDialogShown = isDeleteDialogShown.copy(first = false)
                                recycleBinComponent.onRestore(isDeleteDialogShown.second)
                            }
                        ) {
                            Text("Restore")
                        }

                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                isDeleteDialogShown = isDeleteDialogShown.copy(first = false)
                                recycleBinComponent.onPermanentDelete(isDeleteDialogShown.second)
                            }
                        ) {
                            Text("Delete")
                        }
                    }
                }
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(deletedItems.chunked(4)) { folders ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    folders.forEach { folder ->

                        FolderItem(
                            folderName = folder,
                            onFolderClicked = {
                                isDeleteDialogShown = true to it
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FolderItem(
    folderName: String,
    onFolderClicked: (folderName: String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier.clickable {
            onFolderClicked.invoke(folderName)
        }
    ) {
        androidx.compose.material.Icon(
            painter = painterResource(id = R.drawable.folder_32x32),
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Text(
            text = folderName,
            style = MaterialTheme.typography.caption,
        )
    }
}
