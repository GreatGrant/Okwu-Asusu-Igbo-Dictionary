package com.gralliams.okwuass.feature_dictionary.data.local

import androidx.room.Database
import com.gralliams.okwuass.feature_dictionary.data.local.entity.WordInfoEntity

@Database(
    entities = [WordInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase {
    abstract val dao: WordInfoDao
}