package com.gralliams.okwuass.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.AttributesDto
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.DialectDto
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.ExampleDto
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.TensesDto
import com.gralliams.okwuass.feature_dictionary.domain.model.Example
import com.gralliams.okwuass.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    val definitions: List<String>,
    val pronunciation: String,
    val relatedTerms: List<String>?,
    val word: String?,
    val examples: List<Example>,
    @PrimaryKey val id: String,
    val wordClass: String,
    val nsibidi: String
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            definitions = definitions,
            pronunciation = pronunciation,
            relatedTerms  = relatedTerms,
            word = word,
            examples = examples,
            id = id,
            nsibidi = nsibidi,
            wordClass = wordClass
            )
    }
}