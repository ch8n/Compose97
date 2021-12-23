package io.github.ch8n.compose97.routes.notepad

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ComponentContext
import io.github.ch8n.compose97.navigation.AppNavigation
import io.github.ch8n.compose97.navigation.DecomposeComponent
import io.github.ch8n.compose97.routes.window97.Window97Common
import io.github.ch8n.compose97.ui.components.windowscaffold.StatusBarProps
import io.github.ch8n.compose97.ui.components.windowscaffold.ToolbarGroupProp
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowStatusBar
import io.github.ch8n.compose97.ui.components.windowscaffold.WindowToolbar
import io.github.ch8n.compose97.ui.theme.Gray
import io.github.ch8n.compose97.ui.theme.Silver
import io.github.ch8n.compose97.ui.theme.White
import io.github.ch8n.compose97.ui.theme.notePadTextStyle
import io.github.ch8n.compose97.verticalScrollBars

class NotePadComponent(
    componentContext: ComponentContext
) : DecomposeComponent(componentContext) {

    private val notePad = Window97Common.Notepad

    val statusBar = StatusBarProps(
        title = notePad.label,
        mainIcon = notePad.iconId
    )

    val toolbarProp = listOf(
        ToolbarGroupProp(
            groupName = "File",
            onGroupClicked = {}
        ),
        ToolbarGroupProp(
            groupName = "Edit",
            onGroupClicked = {}
        ),
        ToolbarGroupProp(
            groupName = "View",
            onGroupClicked = {}
        ),
        ToolbarGroupProp(
            groupName = "Help",
            onGroupClicked = {}
        )
    )

    fun onMinimiseClicked() {}
    fun onMaximiseClicked() {}
    fun onCloseClicked() {}
}


@Composable
fun NotePad(
    notePadComponent: NotePadComponent,
    navComponent: AppNavigation,
) {

    val (content, setContent) = remember {
        mutableStateOf(LoremIpsum().values.take(2000).joinToString())
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        WindowStatusBar(
            props = notePadComponent.statusBar,
            modifier = Modifier.fillMaxWidth(),
            onMinimiseClicked = notePadComponent::onMinimiseClicked,
            onMaximiseClicked = notePadComponent::onMaximiseClicked,
            onCloseClicked = notePadComponent::onCloseClicked
        )

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Gray,
        )

        WindowToolbar(
            menuGroup = notePadComponent.toolbarProp,
            modifier = Modifier.fillMaxWidth()
        )

        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .background(Silver)
                .padding(horizontal = 8.dp)
                .border(1.dp, Gray)
                .fillMaxSize()
                .background(White)
                .verticalScroll(scrollState)
                .verticalScrollBars(scrollState)
        ) {
            BasicTextField(
                value = content,
                onValueChange = setContent,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                textStyle = notePadTextStyle
            )
        }
    }


}
