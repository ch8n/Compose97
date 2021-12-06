package io.github.ch8n.compose97.ui.components.windowscaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.Black
import io.github.ch8n.compose97.ui.theme.Silver
import io.github.ch8n.compose97.ui.theme.White

data class WindowProps(
    val statusBar: StatusBarProps,
    val toolbar: List<ToolbarGroupProp>,
    val navToolbar: List<NavToolbarProp>,
    val addressBarPath: String
)

data class NavToolbarProp(
    val name: String,
    val onOptionClicked: () -> Unit,
)

@Composable
fun WindowScaffold(
    props: WindowProps,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier.border(2.dp, Silver)
    ) {

        WindowStatusBar(
            props = props.statusBar,
            modifier = Modifier.fillMaxWidth()
        )

        WindowToolbar(
            menuGroup = props.toolbar,
            modifier = Modifier.fillMaxWidth()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Silver)
                .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                .background(White)
                .border(1.dp, Black)
                .shadow(2.dp)
        ) {
            content()
        }
    }
}


@Preview
@Composable
fun WindowScaffoldPreview() {
    WindowScaffold(
        props = WindowProps(
            statusBar = StatusBarProps(
                title = """C:\\""",
                mainIcon = R.drawable.my_computer_32x32,
                onCloseClicked = {},
                onMaximiseClicked = {},
                onMinimiseClicked = {},
            ),
            toolbar = emptyList(),
            navToolbar = emptyList(),
            addressBarPath = """C:\\"""
        ),
        modifier = Modifier.fillMaxSize()
    ) {

    }
}