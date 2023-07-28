package com.gralliams.okwuass.feature_dictionary.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gralliams.okwuass.feature_dictionary.data.local.entity.WordInfoEntity

class Converters (
    private val gson: Gson
){
    @TypeConverter
    fun fromWordInfoEntity(wordInfo: WordInfoEntity): String {
        return gson.toJson(wordInfo)
    }

    @TypeConverter
    fun toWordInfoEntity(json: String): WordInfoEntity {
        val type = object : TypeToken<WordInfoEntity>() {}.type
        return gson.fromJson(json, type)
    }

}