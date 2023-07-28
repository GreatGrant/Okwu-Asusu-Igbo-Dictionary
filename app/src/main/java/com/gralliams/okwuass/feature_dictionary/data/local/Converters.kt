package com.gralliams.okwuass.feature_dictionary.data.local

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import com.gralliams.okwuass.feature_dictionary.data.util.GsonParser
import com.gralliams.okwuass.feature_dictionary.domain.model.Example
import java.lang.reflect.Type

class Converters(private val gson: Gson) {
    private val gsonParser: GsonParser = GsonParser(gson)

    // Generic method to parse List of any custom class

    // Parse List<ExampleDto> to JSON string
    fun toExampleJson(example: List<Example>): String{
        return gsonParser.toJson(
            example,
            object : TypeToken<List<Example>>() {}.type)  ?: "[]"
    }

    // Parse JSON string to List<ExampleDto>
    fun fromExamplesJson(json: String): List<Example> {
        return gsonParser.fromJson<ArrayList<Example>>(
            json,
            object : TypeToken<List<Example>>() {}.type)  ?: emptyList()
    }

    // Parse List<String> to JSON string
    fun toStringListJson(list: List<String>): String {
        return gsonParser.toJson(
            list,
            object : TypeToken<List<String>>() {}.type
        ) ?: "[]"
    }

    // Parse JSON string to List<String>
    fun fromStringListJson(json: String): List<String> {
        return gsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<List<String>>() {}.type
        ) ?: emptyList()
    }
}
