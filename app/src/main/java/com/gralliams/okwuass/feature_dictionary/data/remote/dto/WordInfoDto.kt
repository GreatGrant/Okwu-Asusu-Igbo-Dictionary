package com.gralliams.okwuass.feature_dictionary.data.remote.dto

import com.gralliams.okwuass.feature_dictionary.data.local.entity.WordInfoEntity
import com.gralliams.okwuass.feature_dictionary.domain.model.WordInfo

data class WordInfoDto
    (
    val definitions: List<String>,
    val pronunciation: String,
    val dialects: Map<String, DialectDto>,
    val tenses: TensesDto,
    val attributes: AttributesDto,
    val relatedTerms: List<String>,
    val word: String,
    val examples: List<ExampleDto>,
    val id: String,
    val wordClass: String,
    val nsibidi: String
            ) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            definitions = definitions,
            pronunciation = pronunciation,
            relatedTerms = relatedTerms,
            word = word,
            examples = examples.map { it.toExample() },
            id = id,
            wordClass = wordClass,
            nsibidi = nsibidi
        )
    }

}