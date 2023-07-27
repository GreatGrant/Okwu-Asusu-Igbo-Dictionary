package com.gralliams.okwuass.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.AttributesDto
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.DialectDto
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.ExampleDto
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.TensesDto
import com.gralliams.okwuass.feature_dictionary.domain.model.WordInfo

@Entity()
data class WordInfoEntity(
    val definitions: List<String>,
    val pronunciation: String,
    val dialects: Map<String, DialectDto>,
    val tenses: TensesDto,
    val attributes: AttributesDto,
    val relatedTerms: List<String>,
    val word: String,
    val examples: List<ExampleDto>,
    @PrimaryKey val id: String,
    val wordClass: String,
    val nsibidi: String
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            definitions = definitions,
            pronunciation = pronunciation,
            tenses = tenses,
            attributes = attributes,
            relatedTerms  = relatedTerms,
            word = word,
            examples = examples,
            id = id,
            nsibidi = nsibidi,
            wordClass = wordClass
            )
    }
}