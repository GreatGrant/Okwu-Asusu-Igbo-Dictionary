package com.gralliams.okwuass.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken

import com.gralliams.okwuass.feature_dictionary.data.util.JsonParser
import com.gralliams.okwuass.feature_dictionary.domain.model.Example

@ProvidedTypeConverter
class Converters(private val jsonParser: JsonParser) {

    // Parse List<Example> to JSON string
    @TypeConverter
    fun toExampleJson(example: List<Example>?): String? {
        return jsonParser.toJson(example ?: emptyList(), object : TypeToken<List<Example>>() {}.type)
    }

    // Parse JSON string to List<Example>
    @TypeConverter
    fun fromExamplesJson(json: String): List<Example> {
        return jsonParser.fromJson<ArrayList<Example>>(
            json,
            object : TypeToken<List<Example>>() {}.type
        ) ?: emptyList()
    }

    // Parse List<String> to JSON string
    @TypeConverter
    fun toStringListJson(list: List<String>?): String? {
        return jsonParser.toJson(list ?: emptyList(), object : TypeToken<List<String>>() {}.type)
    }

    // Parse JSON string to List<String>
    @TypeConverter
    fun fromStringListJson(json: String): List<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<List<String>>() {}.type
        ) ?: emptyList()
    }
}
