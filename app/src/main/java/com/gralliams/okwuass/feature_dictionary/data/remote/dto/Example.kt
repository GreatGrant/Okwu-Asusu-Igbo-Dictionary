package com.gralliams.okwuass.feature_dictionary.data.remote.dto

data class Example(
    val igbo: String,
    val english: String,
    val nsibidiCharacters: List<Any>,
    val type: String,
    val pronunciations: List<Pronunciation>
)