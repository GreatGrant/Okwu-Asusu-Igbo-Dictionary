package com.gralliams.okwuass.feature_dictionary.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gralliams.okwuass.feature_dictionary.domain.model.WordInfo

@Composable
fun WordInfoItem(
    wordInfo: WordInfo,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = wordInfo.word,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = wordInfo.nsibidi ?: "",
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
            Text(
                text = wordInfo.wordClass,
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
        }
//        Text(text = wordInfo.pronunciation ?: "", fontWeight = FontWeight.Light)
        wordInfo.pronunciation?.let{
            Icon(
               imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play Pronunciation",
                tint = Color.Blue,
                modifier = Modifier
                    .clickable {
                        //Todo() Handle playing the pronunciation audio here

                    }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        wordInfo.definitions.forEachIndexed { i, definition ->
            Text(text = "${i + 1}. $definition")
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Examples:", fontWeight = FontWeight.Bold)
        wordInfo.examples.forEachIndexed { i, example ->
            Text(text = "${i + 1}. ${example.igbo}")
            example.english?.let { Text(text = it) }
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
