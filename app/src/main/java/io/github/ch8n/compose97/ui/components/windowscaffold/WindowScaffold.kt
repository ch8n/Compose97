package io.github.ch8n.compose97.ui.components.windowscaffold

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.*

data class WindowProps(
    val title: String,
    @DrawableRes val mainIcon: Int,
    val onMinimiseClicked: () -> Unit,
    val onMaximiseClicked: () -> Unit,
    val onCloseClicked: () -> Unit,
    val toolbar: List<ToolbarOptionProp>,
    val navToolbar: List<NavToolbarProp>,
    val addressBarPath: String
)

data class ToolbarOptionProp(
    val name: String,
    val onOptionClicked: () -> Unit,
)

data class NavToolbarProp(
    val name: String,
    val onOptionClicked: () -> Unit,
)

@Composable
fun WindowScaffold(
    props: WindowProps,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(2.dp, Silver)
    ) {

        MainStatusBar(props)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Silver)
                .padding(vertical = 4.dp),
        ) {

            val menuItem = listOf("File", "Edit", "View", "Help")
            menuItem.forEach {
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append(it.take(1))
                    }
                    append(it.drop(1))
                })
            }
        }

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

@Composable
private fun MainStatusBar(props: WindowProps) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Navy,
                        RoyalBlue
                    )
                )
            )
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = props.mainIcon),
                modifier = Modifier.size(16.dp),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = props.title, color = White, fontWeight = FontWeight.SemiBold)
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_mini_toolbar),
                modifier = Modifier
                    .size(16.dp)
                    .border(1.dp, Black)
                    .background(Silver)
                    .padding(4.dp),
                contentDescription = null,
                tint = Black
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_maxi_toolbar),
                modifier = Modifier
                    .size(16.dp)
                    .border(1.dp, Black)
                    .background(Silver)
                    .padding(4.dp),
                contentDescription = null,
                tint = Black
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_close_toolbar),
                modifier = Modifier
                    .size(16.dp)
                    .border(1.dp, Black)
                    .background(Silver)
                    .padding(4.dp),
                contentDescription = null,
                tint = Black
            )
        }
    }
}

@Preview
@Composable
fun WindowScaffoldPreview() {
    WindowScaffold(
        props = WindowProps(
            title = """C:\\""",
            mainIcon = R.drawable.my_computer_32x32,
            onCloseClicked = {},
            onMaximiseClicked = {},
            onMinimiseClicked = {},
            toolbar = emptyList(),
            navToolbar = emptyList(),
            addressBarPath = """C:\\"""
        )
    ) {

    }
}