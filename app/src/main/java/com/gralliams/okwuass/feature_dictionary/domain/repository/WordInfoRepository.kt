package com.gralliams.okwuass.feature_dictionary.domain.repository

import com.gralliams.okwuass.core.util.Resource
import com.gralliams.okwuass.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordRepository(word: String): Flow<Resource<List<WordInfo>>>
}