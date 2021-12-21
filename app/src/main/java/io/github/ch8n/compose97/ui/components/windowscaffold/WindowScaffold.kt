package io.github.ch8n.compose97.ui.components.windowscaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.*

data class WindowProps(
    val statusBar: StatusBarProps,
    val toolbar: List<ToolbarGroupProp>,
    val navToolbar: List<NavToolbarProp>,
    val addressBar: WindowAddressProps,
    val isMinimised: Boolean = false,
    val isMaximised: Boolean = false,
    val showDetailPanel: Boolean = true,
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
            if (!props.showDetailPanel) {
                content.invoke()
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                0.15f to RoyalBlue,
                                0.30f to White,
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 48.dp, start = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = props.statusBar.mainIcon),
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(56.dp),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )

                        Text(
                            text = props.statusBar.title,
                            style = MaterialTheme.typography.h2,
                        )

                        Box(
                            modifier =
                            Modifier
                                .fillMaxWidth(0.8f)
                                .height(2.5.dp)
                                .background(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            Color.Red,
                                            Color.Yellow,
                                            Color.Green,
                                            Color.Blue
                                        )
                                    )
                                )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    content.invoke()
                }
            }

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
                path = """C:\\""",
                name = "C:"
            ),
            isMaximised = true
        ),
        onMinimiseClicked = {},
        onMaximiseClicked = {},
        onCloseClicked = {},
    ) {
    }
}
