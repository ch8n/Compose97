package io.github.ch8n.compose97.ui.components.windowscaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.Black
import io.github.ch8n.compose97.ui.theme.Gray
import io.github.ch8n.compose97.ui.theme.Silver
import io.github.ch8n.compose97.ui.theme.White

data class WindowProps(
    val statusBar: StatusBarProps,
    val toolbar: List<ToolbarGroupProp>,
    val navToolbar: List<NavToolbarProp>,
    val addressBar: WindowAddressProps
)

@Composable
fun WindowScaffold(
    props: WindowProps,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier.border(2.dp, Silver),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        WindowStatusBar(
            props = props.statusBar,
            modifier = Modifier.fillMaxWidth()
        )

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Gray,
        )

        WindowToolbar(
            menuGroup = props.toolbar,
            modifier = Modifier.fillMaxWidth()
        )

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Gray,
        )

        WindowNavToolbar(
            modifier = Modifier.fillMaxWidth(),
            toolbarOptions = props.navToolbar
        )

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Gray,
        )

        WindowAddressBar(
            props = props.addressBar,
            modifier = Modifier.fillMaxWidth()
        )

        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Gray,
        )

        Box(
            modifier = Modifier
                .background(Silver)
                .padding(top = 8.dp)
                .fillMaxWidth()
                .fillMaxHeight()
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
            toolbar = listOf(
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
                ),
            ),
            navToolbar = listOf(
                NavToolbarProp(
                    name = "Back",
                    iconRes = R.drawable.ic_back_navtool,
                    onOptionClicked = {}
                ),
                NavToolbarProp(
                    name = "Forward",
                    iconRes = R.drawable.ic_forward_navtool,
                    onOptionClicked = {}
                ),
                NavToolbarProp(
                    name = "Up",
                    iconRes = R.drawable.ic_up_navtool,
                    onOptionClicked = {}
                ),
                NavToolbarProp(
                    name = "Delete",
                    iconRes = R.drawable.ic_delete_navtool,
                    isExtra = true,
                    onOptionClicked = {}
                ),
            ),
            addressBar = WindowAddressProps(
                iconRes = R.drawable.my_computer_32x32,
                path = """C:\\"""
            )
        ),
        modifier = Modifier.fillMaxSize()
    ) {
    }
}
