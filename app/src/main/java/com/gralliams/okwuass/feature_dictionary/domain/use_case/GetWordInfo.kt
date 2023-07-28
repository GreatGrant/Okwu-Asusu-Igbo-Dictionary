package com.gralliams.okwuass.feature_dictionary.domain.use_case

import com.gralliams.okwuass.core.util.Resource
import com.gralliams.okwuass.feature_dictionary.domain.model.WordInfo
import com.gralliams.okwuass.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>>{
        // validation logic here
        if (word.isBlank()){
            return flow{ }
        }
        return repository.getWordInfo(word)
    }
}