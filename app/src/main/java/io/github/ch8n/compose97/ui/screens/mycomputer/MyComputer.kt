import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import io.github.ch8n.compose97.R
import io.github.ch8n.compose97.ui.components.windowscaffold.*
import io.github.ch8n.compose97.ui.screens.folder.FolderWindowContent
import java.util.*


// TODO folders and search
data class Note(
    val id: String,
    val name: String,
    val content: String,
    val updatedAt: Long,
    val group: String,
) {
    companion object {
        val SAMPLE
            get() = Note(
                id = UUID.randomUUID().toString(),
                name = "file",
                content = LoremIpsum().values.take(5).toString(),
                updatedAt = System.currentTimeMillis(),
                group = sampleGroup.random()
            )
    }
}

val sampleGroup = mutableListOf<String>().apply {
    repeat(10) {
        add("folder${it + 1}")
    }
}

val sampleNotes = mutableListOf<Note>().apply {
    repeat(100) {
        add(Note.SAMPLE.copy(name = "File ${it + 1}"))
    }
}
