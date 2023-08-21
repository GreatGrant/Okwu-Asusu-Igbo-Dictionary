package com.gralliams.okwuass.feature_dictionary.data.remote

import com.gralliams.okwuass.BuildConfig
import com.gralliams.okwuass.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val API_KEY = BuildConfig.API_KEY
interface DictionaryApi {
    //https://igboapi.com/api/v1/words?keyword={word}&page=1
    // https://igboapi.com/api/v1/words?keyword=go&examples=true&page=1
//    https://igboapi.com/api/v1/words?keyword=dog&examples=true
//    @Headers(
//        "X-API-KEY: $API_KEY",
//    )
//    @GET("/words?keyword={word}&examples=true")
//    suspend fun getWordInfo(
//        @Path("word") word: String
//    ): List<WordInfoDto>


    @Headers("X-API-KEY: $API_KEY")
    @GET("words")
    suspend fun getWordInfo(
        @Query("keyword") word: String,
        @Query("examples") examples: Boolean = true
    ): List<WordInfoDto>

    companion object{
        const val BASE_URL = "https://igboapi.com/api/v1/"
    }
}