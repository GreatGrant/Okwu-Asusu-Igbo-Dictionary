package com.gralliams.okwuass.feature_dictionary.domain.model

import com.gralliams.okwuass.feature_dictionary.data.remote.dto.AttributesDto
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.DialectDto
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.ExampleDto
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.TensesDto

class WordInfo(
    val definitions: List<String>,
    val pronunciation: String,
    val tenses: TensesDto,
    val attributes: AttributesDto,
    val relatedTerms: List<String>,
    val word: String,
    val examples: List<ExampleDto>,
    val id: String,
    val wordClass: String,
    val nsibidi: String
)