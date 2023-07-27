package com.gralliams.okwuass.feature_dictionary.data.remote.dto

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
            )