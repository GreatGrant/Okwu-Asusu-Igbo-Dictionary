package com.gralliams.okwuass.feature_dictionary.data.remote.dto

import com.gralliams.okwuass.feature_dictionary.domain.model.Example

data class ExampleDto(
    val igbo: String,
    val english: String,
    val nsibidiCharacters: List<String>,
    val type: String,
    val pronunciations: List<PronunciationDto>
){
    fun toExample(): Example {
        return Example(
            igbo = igbo,
            english = english,
            nsibidiCharacters = nsibidiCharacters,
            type = type,
            pronunciations = pronunciations.map { it.toPronunciation() }
        )
    }
}