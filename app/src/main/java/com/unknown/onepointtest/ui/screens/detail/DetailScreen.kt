package com.unknown.onepointtest.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.unknown.onepointtest.ui.screens.home.HomeViewModel

@Composable
fun DetailScreen(
    id : String?,
    viewModel: DetailViewModel = hiltViewModel(),
    modifier :Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(text = viewModel.uiState.data?.name ?: "ERR")
    }
}