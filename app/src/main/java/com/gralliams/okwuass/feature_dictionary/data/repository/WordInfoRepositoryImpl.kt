package com.gralliams.okwuass.feature_dictionary.data.repository

import com.gralliams.okwuass.core.util.Resource
import com.gralliams.okwuass.feature_dictionary.data.local.WordInfoDao
import com.gralliams.okwuass.feature_dictionary.data.remote.DictionaryApi
import com.gralliams.okwuass.feature_dictionary.domain.model.WordInfo
import com.gralliams.okwuass.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
):WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow{
        emit(Resource.Loading())

        // read cached data from database and map data object to domain level object
        val wordInfos =  dao.getWordInfos(word).map { it.toWordInfo() }

        emit(Resource.Loading(data = wordInfos))

        // Get word from API and replace in database
        try {
            val remoteWordInfo = api.getWordInfo(word)
            dao.apply {
                deleteWordInfos(remoteWordInfo.map{ it.word })
                insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })
            }
        }catch (e: HttpException){
            emit(Resource.Error(
                message = "Oops something went wrong!",
                data = wordInfos
            ))
        }catch (e: IOException){
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection",
                data = wordInfos
            ))
        }

        // Get updated data from database and emit data to the UI
        val newWordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))
    }
}