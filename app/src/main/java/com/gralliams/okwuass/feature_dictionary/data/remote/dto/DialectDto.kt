package com.gralliams.okwuass.feature_dictionary.data.remote.dto

data class DialectDto(
    val variations: List<String>,
    val dialects: List<String>,
    val pronunciation: String,
    val _id: String,
    val word: String
)