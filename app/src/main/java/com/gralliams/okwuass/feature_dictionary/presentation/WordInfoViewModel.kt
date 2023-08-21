package com.gralliams.okwuass.feature_dictionary.presentation
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gralliams.okwuass.core.util.Resource
import com.gralliams.okwuass.core.util.delayTime
import com.gralliams.okwuass.feature_dictionary.domain.use_case.GetWordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

//Todo() search: Resource.Success: [] returns empty array when english word input Fix.
//Inject use case
@HiltViewModel
class WordInfoViewModel @Inject constructor (
    private val getWordInfo: GetWordInfo
        ): ViewModel(){
    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _state = mutableStateOf(WordInfoState())
    val state: State<WordInfoState> = _state

    // Sends one time event to UI
    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null

    private var mediaPlayer: MediaPlayer? = null

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: Flow<Boolean> = _isPlaying
    fun playPronunciation(url: String) {
        stopPlaying()
        mediaPlayer = MediaPlayer().apply {
            setDataSource(url)
            prepareAsync()
            setOnPreparedListener {
                it.start()
                _isPlaying.value = true
            }
            setOnCompletionListener {
                stopPlaying()
                _isPlaying.value = false
            }
        }

    }

    fun stopPlaying() {
        mediaPlayer?.apply {
            stop()
            release()
        }
        mediaPlayer = null
    }

    override fun onCleared() {
        super.onCleared()
        stopPlaying()
    }

    fun search(query: String){
        Log.d("WordInfoViewModel", "search: Entered with query: $query")

        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(delayTime)
            getWordInfo(query)
                .onEach { result ->
                    when(result){
                        is Resource.Success -> {
                            Log.d("WordInfoViewModel", "search: Resource.Success: ${result.data}")
                            _state.value = state.value.copy(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                            // Play pronunciation audio if available
                            result.data?.firstOrNull()?.pronunciation?.let {
                                playPronunciation(it)
                            }
                        }
                        is Resource.Error -> {
                            Log.d("WordInfoViewModel", "search: Resource.Error: ${result.message}")
                            _state.value = state.value.copy(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )

                            _eventFlow.emit(UIEvent.ShowSnackbar(
                                result.message ?: "Unknown error"
                            ))
                        }
                        is Resource.Loading -> {
                            Log.d("WordInfoViewModel", "search: Resource.Loading")
                            _state.value = state.value.copy(
                                wordInfoItems = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
    sealed class UIEvent {
        data class ShowSnackbar (val message: String): UIEvent()
    }
}
