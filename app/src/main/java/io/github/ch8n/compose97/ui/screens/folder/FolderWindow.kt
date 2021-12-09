package io.github.ch8n.compose97.ui.screens.folder

import Note
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import sampleNotes
import java.util.*

// nav option -> Notes/files -> search, create, delete, back, forward
@Composable
fun FolderWindow() {
    TODO("make window for folder")
}

@Composable
fun FolderWindowContent(
    files: List<Note>,
    onFileClicked: (Note) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = rememberLazyListState(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(files.chunked(4)) { set4Notes ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                set4Notes.forEach { note ->
                    NotePadIcon(
                        note = note,
                        onNoteClicked = {
                            onFileClicked.invoke(note)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun NotePadIcon(
    note: Note,
    onNoteClicked: () -> Unit
) {
    Column(
        modifier = Modifier.clickable(onClick = onNoteClicked),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.notepad_file_32x32),
            modifier = Modifier.size(24.dp),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Text(
            text = note.name,
            style = MaterialTheme.typography.caption,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.widthIn(max = 64.dp)
        )
    }
}


@Preview
@Composable
fun FolderPreview() {
    io.github.ch8n.compose97.ui.components.Preview {
        FolderWindowContent(
            files = sampleNotes
                .groupBy { it.group }
                .values
                .toList()
                .first()
                .map { it.copy(name = UUID.randomUUID().toString()) },
            onFileClicked = {

            }
        )
    }
}