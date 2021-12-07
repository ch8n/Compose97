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
    val addressBar: WindowAddressProps,
    val isMinimised: Boolean = false,
    val isMaximised: Boolean = false,
) {
    companion object {
        val NoWindow = WindowProps(
            statusBar = StatusBarProps.Empty,
            toolbar = listOf(ToolbarGroupProp.Empty),
            navToolbar = listOf(NavToolbarProp.Empty),
            addressBar = WindowAddressProps.Empty
        )
    }
}

@Composable
fun WindowScaffold(
    props: WindowProps,
    modifier: Modifier = Modifier,
    onMinimiseClicked: () -> Unit,
    onMaximiseClicked: () -> Unit,
    onCloseClicked: () -> Unit,
    content: @Composable () -> Unit,
) {
    if (props.isMinimised) {
        return
    }

    Column(
        modifier = modifier
            .fillMaxWidth(if (props.isMaximised) 1f else 0.75f)
            .fillMaxHeight(if (props.isMaximised) 1f else 0.65f)
            .border(2.dp, Silver),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        WindowStatusBar(
            props = props.statusBar,
            modifier = Modifier.fillMaxWidth(),
            onMinimiseClicked = onMinimiseClicked,
            onMaximiseClicked = onMaximiseClicked,
            onCloseClicked = onCloseClicked
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
            ),
        ),
        onMinimiseClicked = {},
        onMaximiseClicked = {},
        onCloseClicked = {}
    ) {
    }
}
