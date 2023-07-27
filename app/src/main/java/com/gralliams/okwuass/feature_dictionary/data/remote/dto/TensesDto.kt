package com.gralliams.okwuass.feature_dictionary.data.remote.dto

import com.gralliams.okwuass.feature_dictionary.domain.model.Tenses

data class TensesDto(
    val infinitive: String?,
    val imperative: String?,
    val simplePast: String?,
    val presentPassive: String?,
    val simplePresent: String,
    val presentContinuous: String?,
    val future: String?
){
    fun toTenses(): Tenses {
        return Tenses(
            infinitive = infinitive,
            imperative = imperative,
            simplePast = simplePast,
            presentPassive = presentPassive,
            simplePresent = simplePresent,
            presentContinuous = presentContinuous,
            future = future
        )
    }
}