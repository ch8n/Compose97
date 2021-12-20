package io.github.ch8n.compose97.routes.mydocuments

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
import io.github.ch8n.compose97.navigation.NavigationComponent
import io.github.ch8n.compose97.routes.window97.Window97Common
import io.github.ch8n.compose97.ui.components.windowscaffold.StatusBarProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowAddressProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowProps
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowScaffold

class MyDocumentComponent(
    componentContext: ComponentContext,
) : DecomposeComponent(componentContext) {

    val myDocument = Window97Common.MyDocuments

    val statusBar = StatusBarProps(
        title = myDocument.label,
        mainIcon = myDocument.iconId
    )

    val windowProps = WindowAddressProps(
        iconRes = myDocument.iconId,
        name = myDocument.label,
        path = "~${myDocument.label.capitalize()}://"
    )

    fun recentDocuments(): MutableList<String> {
        return mutableListOf<String>().apply {
            repeat(10) {
                add("document${it + 1}")
            }
        }
    }

    fun onMinimiseClicked() {}
    fun onMaximiseClicked() {}
    fun onCloseClicked() {}

    fun onDocumentClicked(document: String) {
    }
}

@Composable
fun MyDocument(
    myDocumentComponent: MyDocumentComponent,
    navComponent: NavigationComponent,
) {
    val recycleBinWindowProps = remember {
        WindowProps(
            statusBar = myDocumentComponent.statusBar,
            toolbar = emptyList(),
            navToolbar = emptyList(),
            addressBar = myDocumentComponent.windowProps,
            isMaximised = true
        )
    }

    WindowScaffold(
        props = recycleBinWindowProps,
        onMinimiseClicked = myDocumentComponent::onMinimiseClicked,
        onMaximiseClicked = myDocumentComponent::onMaximiseClicked,
        onCloseClicked = myDocumentComponent::onCloseClicked
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(myDocumentComponent.recentDocuments().chunked(4)) { folders ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    folders.forEach { folder ->

                        FolderItem(
                            fileName = folder,
                            onFolderClicked = myDocumentComponent::onDocumentClicked
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun FolderItem(
    fileName: String,
    onFolderClicked: (folderName: String) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier.clickable {
            onFolderClicked.invoke(fileName)
        }
    ) {
        androidx.compose.material.Icon(
            painter = painterResource(id = R.drawable.notepad_file_32x32),
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.Unspecified
        )

        Text(
            text = fileName,
            style = MaterialTheme.typography.caption,
        )
    }
}
