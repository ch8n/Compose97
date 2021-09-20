package io.github.ch8n.compose97.ui.components.mycomputer

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.theme.Black
import io.github.ch8n.compose97.ui.theme.Gray
import io.github.ch8n.compose97.ui.theme.Silver
import io.github.ch8n.compose97.ui.theme.White

@Composable
fun MyComputer(
    title: String,
    @DrawableRes icon: Int,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(2.dp, Silver)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    modifier = Modifier.size(16.dp),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = title, color = White, fontWeight = FontWeight.SemiBold)
            }

            Row {
                Icon(
                    painter = painterResource(id = icon),
                    modifier = Modifier.size(16.dp),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = icon),
                    modifier = Modifier.size(16.dp),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = icon),
                    modifier = Modifier.size(16.dp),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }

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

@Preview
@Composable
fun MyComputerPreview() {
    MyComputer(
        title = """C:\\""",
        icon = R.drawable.my_computer_32x32
    ) {

    }
}