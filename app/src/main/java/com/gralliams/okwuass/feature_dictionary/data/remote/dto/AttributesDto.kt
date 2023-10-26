package com.gralliams.okwuass.feature_dictionary.data.remote.dto

import com.gralliams.okwuass.feature_dictionary.domain.model.Attributes

data class AttributesDto(
    val isStandardIgbo: Boolean,
    val isAccented: Boolean,
    val isSlang: Boolean,
    val isConstructedTerm: Boolean,
    val isBorrowedTerm: Boolean,
    val isStem: Boolean,
    val isCommon: Boolean
){
    fun toAttributes(): Attributes{
        return Attributes(
            isStandardIgbo = isStandardIgbo,
            isAccented = isAccented,
            isSlang = isSlang,
            isConstructedTerm = isConstructedTerm,
            isBorrowedTerm = isBorrowedTerm,
            isStem = isStem,
            isCommon = isCommon
        )
    }

}