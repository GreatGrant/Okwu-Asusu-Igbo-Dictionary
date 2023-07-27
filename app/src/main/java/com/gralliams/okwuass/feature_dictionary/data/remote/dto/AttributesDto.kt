package com.gralliams.okwuass.feature_dictionary.data.remote.dto

data class AttributesDto(
    val isStandardIgbo: Boolean,
    val isAccented: Boolean,
    val isSlang: Boolean,
    val isConstructedTerm: Boolean,
    val isBorrowedTerm: Boolean,
    val isStem: Boolean,
    val isCommon: Boolean
)