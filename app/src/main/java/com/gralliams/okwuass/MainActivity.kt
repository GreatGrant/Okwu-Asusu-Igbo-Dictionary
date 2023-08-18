package com.gralliams.okwuass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gralliams.okwuass.feature_dictionary.presentation.WordInfoItem
import com.gralliams.okwuass.feature_dictionary.presentation.WordInfoState
import com.gralliams.okwuass.feature_dictionary.presentation.WordInfoViewModel
import com.gralliams.okwuass.ui.theme.OkwuAsụsụTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OkwuAsụsụTheme {
                val viewModel: WordInfoViewModel = hiltViewModel()
                val state = viewModel.state.value
                val scaffoldState = rememberScaffoldState()

                LaunchedEffect(key1 = true) {
                    viewModel.eventFlow.collectLatest { event ->
                        when (event) {
                            is WordInfoViewModel.UIEvent.ShowSnackbar -> {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    message = event.message
                                )
                            }
                        }
                    }
                }

                OkwuAsusuApp(viewModel, scaffoldState, state)

            }
        }
    }

    @Composable
    private fun OkwuAsusuApp(
        viewModel: WordInfoViewModel,
        scaffoldState: ScaffoldState,
        state: WordInfoState
    ) {

        Scaffold(scaffoldState = scaffoldState) { innerPadding ->

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colors.surface),
                color = MaterialTheme.colors.background

            ) {
                Box(
                    modifier = Modifier.background(MaterialTheme.colors.background)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        TextField(
                            value = viewModel.searchQuery.value,
                            onValueChange = { newText -> viewModel.search(newText) }, // Adjust the parameter type as needed
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text(text = "Search...") }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(state.wordInfoItems.size) { i ->
                                val wordInfo = state.wordInfoItems[i]
                                if (i > 0) {
                                    Spacer(modifier = Modifier.height(8.dp))
                                }
                                WordInfoItem(wordInfo = wordInfo)
                                if (i < state.wordInfoItems.size - 1) {
                                    Divider()
                                }
                            }
                        }
                    }
                    if (state.isLoading)
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

            }

        }
    }

    @Preview(
        showBackground = true,
        showSystemUi = true
    )
    @Composable
    fun OkwuAsusuPreview() {
        OkwuAsụsụTheme {
            val viewModel: WordInfoViewModel = hiltViewModel()
            val state = viewModel.state.value
            val scaffoldState = rememberScaffoldState()

            OkwuAsusuApp(viewModel = viewModel, scaffoldState = scaffoldState, state = state)
        }
    }
}