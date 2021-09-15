package io.github.ch8n.compose97.ui.components.taskbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.ui.theme.Black
import io.github.ch8n.compose97.ui.theme.Gray
import io.github.ch8n.compose97.ui.theme.Silver
import io.github.ch8n.compose97.R

@Composable
fun TaskBar(modifier: Modifier){
    Row(
        modifier = modifier
            .border(width = 1.dp, color = Gray)
            .background(Silver)
    ) {

        Button(
            onClick = {},
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Black
                )
                .shadow(
                    elevation = 2.dp
                )
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_windows95),
                    contentDescription = "start button",
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Start",
                    style = MaterialTheme.typography.button
                )
            }
        }

    }
}

@Preview
@Composable
fun TaskBarPreview(){
    TaskBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
    )
}