package io.github.ch8n.compose97.ui.components.windowscaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.ui.theme.Silver

data class ToolbarGroupProp(
    val groupName: String,
    val onGroupClicked: () -> Unit,
) {
    companion object {
        val Empty = ToolbarGroupProp(
            groupName = "Blank",
            onGroupClicked = {}
        )
    }
}

@Preview
@Composable
fun WindowToolbarPreview() {
    val menuItems = listOf(
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
    )
    WindowToolbar(
        menuGroup = menuItems,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun WindowToolbar(
    menuGroup: List<ToolbarGroupProp>,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .background(Silver)
            .padding(vertical = 4.dp)
            .horizontalScroll(state = rememberScrollState()),
    ) {
        menuGroup.forEach { menu ->
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append(menu.groupName.take(1))
                    }
                    append(menu.groupName.drop(1))
                },
                modifier = Modifier.clickable(
                    onClick = menu.onGroupClicked
                )
            )
        }
    }
}
