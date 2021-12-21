package io.github.ch8n.compose97.routes.mycomputer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.navigation.DecomposeComponent
import io.github.ch8n.compose97.navigation.AppNavigation
import io.github.ch8n.compose97.ui.components.windowscaffold.StatusBarProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowAddressProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowScaffold

class MyComputerComponent(
    componentContext: ComponentContext,
) : DecomposeComponent(componentContext) {

    val statusBar = StatusBarProps(
        title = "(C:)",
        mainIcon = R.drawable.drive_32x32
    )

    fun getFolders(): List<String> {
        return mutableListOf<String>().apply {
            repeat(10) {
                add("folder${it + 1}")
            }
        }
    }

    fun onMinimiseClicked() {}
    fun onMaximiseClicked() {}
    fun onCloseClicked() {}
    fun onFolderClicked(folder: String) {
    }
}

@Composable
fun MyComputer(
    myComputerComponent: MyComputerComponent,
    navComponent: AppNavigation,
) {
    val myComputerProps = remember {
        WindowProps(
            statusBar = myComputerComponent.statusBar,
            toolbar = emptyList(),
            navToolbar = emptyList(),
            addressBar = WindowAddressProps(
                iconRes = R.drawable.drive_32x32,
                name = "(C:)",
                path = "C://"
            ),
            isMaximised = true
        )
    }
    WindowScaffold(
        props = myComputerProps,
        onMinimiseClicked = myComputerComponent::onMinimiseClicked,
        onMaximiseClicked = myComputerComponent::onMaximiseClicked,
        onCloseClicked = myComputerComponent::onCloseClicked
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(myComputerComponent.getFolders().chunked(4)) { folders ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    folders.forEach { folder ->
                        FolderItem(
                            folderName = folder,
                            onFolderClicked = myComputerComponent::onFolderClicked
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
