package com.gralliams.okwuass.feature_dictionary.presentation
import androidx.lifecycle.ViewModel
import com.gralliams.okwuass.feature_dictionary.domain.use_case.GetWordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//Inject use case
@HiltViewModel
class WordInfoViewModel @Inject constructor (
    private val getWordInfo: GetWordInfo
        ): ViewModel(){

}
