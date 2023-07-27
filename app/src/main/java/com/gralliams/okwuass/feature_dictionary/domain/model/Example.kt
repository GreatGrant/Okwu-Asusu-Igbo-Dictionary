package com.gralliams.okwuass.feature_dictionary.domain.model

import com.gralliams.okwuass.feature_dictionary.data.remote.dto.PronunciationDto

class Example(
    val igbo: String,
    val english: String,
    val nsibidiCharacters: List<String>,
    val type: String,
    val pronunciations: List<Pronunciation>
)
