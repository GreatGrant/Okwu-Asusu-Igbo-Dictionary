package com.gralliams.okwuass

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.gralliams.okwuass.feature_dictionary.presentation.WordInfoItem
import com.gralliams.okwuass.feature_dictionary.presentation.WordInfoState
import com.gralliams.okwuass.feature_dictionary.presentation.WordInfoViewModel
import com.gralliams.okwuass.ui.theme.OkwuAsụsụTheme
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OkwuAsụsụTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DictionaryApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DictionaryApp() {
    val viewModel: WordInfoViewModel = hiltViewModel()
    val state = viewModel.state.value
    val searchQuery = viewModel.searchQuery.value // Access searchQuery separately

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
        // Observe the eventFlow to show Snackbar whenever a ShowSnackbar event is emitted
        viewModel.eventFlow.collect { event ->
            when (event) {
                is WordInfoViewModel.UIEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Okwu Asụsụ Dictionary")
                },
                actions = {
                    DictionarySearchBar(
                        searchQuery = searchQuery, // Pass searchQuery as a parameter
                        onSearchQueryChanged = { query ->
                            viewModel.search(query)
                        }
                    )
                }
            )
        }
    ) {
        WordInfoList(state = state) // Pass the entire state object
    }
}

@Composable
fun DictionarySearchBar(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit
) {
    var query by remember { mutableStateOf(searchQuery) }
    val scope = rememberCoroutineScope()

    OutlinedTextField(
        value = query,
        onValueChange = {
            query = it
            scope.launch {
                delay(300) // debounce time
                onSearchQueryChanged(it)
            }
        },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Search") },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) }
    )
}

@Composable
fun WordInfoList(state: WordInfoState) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(state.wordInfoItems) { wordInfo ->
            WordInfoItem(wordInfo = wordInfo)
        }
    }
}
