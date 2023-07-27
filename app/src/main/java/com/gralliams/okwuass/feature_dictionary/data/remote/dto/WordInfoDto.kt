package com.gralliams.okwuass.feature_dictionary.data.remote.dto

data class WordInfoDto
    (
    val definitions: List<String>,
    val pronunciation: String,
    val dialects: Map<String, Dialect>,
    val tenses: Tenses,
    val attributes: Attributes,
    val relatedTerms: List<String>,
    val word: String,
    val examples: List<Example>)