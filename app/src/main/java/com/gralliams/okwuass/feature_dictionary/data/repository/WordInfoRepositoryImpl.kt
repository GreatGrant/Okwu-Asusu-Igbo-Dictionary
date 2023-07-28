package com.gralliams.okwuass.feature_dictionary.data.repository

import com.gralliams.okwuass.core.util.Resource
import com.gralliams.okwuass.feature_dictionary.data.local.WordInfoDao
import com.gralliams.okwuass.feature_dictionary.data.remote.DictionaryApi
import com.gralliams.okwuass.feature_dictionary.domain.model.WordInfo
import com.gralliams.okwuass.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
):WordInfoRepository {

    override fun getWordRepository(word: String): Flow<Resource<List<WordInfo>>> = flow{

    }
}