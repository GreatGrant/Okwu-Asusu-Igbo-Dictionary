package com.gralliams.okwuass.feature_dictionary.data.remote.dto

import com.gralliams.okwuass.feature_dictionary.domain.model.Pronunciation

data class PronunciationDto(
    val audio: String,
    val speaker: String
){
    fun toPronunciation(): Pronunciation{
        return Pronunciation(audio, speaker)
    }
}