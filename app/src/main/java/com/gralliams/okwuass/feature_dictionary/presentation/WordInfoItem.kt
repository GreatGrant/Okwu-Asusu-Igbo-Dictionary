package com.gralliams.okwuass.feature_dictionary.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gralliams.okwuass.R
import com.gralliams.okwuass.feature_dictionary.domain.model.WordInfo

@Composable
fun WordInfoItem(
    wordInfo: WordInfo,
    wordInfoViewModel: WordInfoViewModel,
    modifier: Modifier = Modifier
) {

    var isPlaying by remember { mutableStateOf<Boolean>(false) }

    // Observe the isPlaying state from the ViewModel
    isPlaying = wordInfoViewModel.isPlaying.collectAsState(initial = false).value

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            wordInfo.word?.let {
                Text(
                    text = it,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Text(
                text = wordInfo.nsibidi ?: "",
                color = Color.Gray,
                fontFamily = FontFamily(Font(R.font.akagu2020_3)),
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            )

            Text(
                text = getWordClass(wordInfo.wordClass) ,
                color = Color.Gray,
                fontStyle = FontStyle.Italic
            )
        }
        wordInfo.pronunciation?.let{

            Icon(
                painter = if (isPlaying) painterResource(id = R.drawable.baseline_pause_24) else painterResource(id = R.drawable.baseline_play_arrow_24),
                contentDescription = "Play/Pause Pronunciation",
                tint = Color.Blue,
                modifier = Modifier
                    .clickable {

                        if (isPlaying) {
                        } else {
                            isPlaying = true
                            wordInfoViewModel.playPronunciation(it)
                        }
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

fun getWordClass(type: String): String {

    return  when (type) {
        "ADJ" -> return "Adjective"
        "ADV" -> return "Adverb"
        "AV" -> return "Active verb"
        "MV" -> return "Medial verb"
        "PV" -> return "Passive verb"
        "CJN" -> return "Conjunction"
        "DEM" -> return "Demonstrative"
        "NM" -> return "Name"
        "NNC" -> return "Noun"
        "NNP" -> return "Proper noun"
        "CD" -> return "Number"
        "PREP" -> return "Preposition"
        "PRN" -> return "Pronoun"
        "FW" -> return "Foreign word"
        "QTF" -> return "Quantifier"
        "WH" -> return "Interrogative"
        "INTJ" -> return "Interjection"
        "ISUF" -> return "Inflectional suffix"
        "ESUF" -> return "Extensional suffix"
        "SYM" -> return "Punctuations"
        else -> "Unknown"
    }
}
