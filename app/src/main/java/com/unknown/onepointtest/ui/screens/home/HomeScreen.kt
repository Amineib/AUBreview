package com.unknown.onepointtest.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onDetailClicked : (String) -> Unit
) {
    val state = viewModel.uiState
    if(state.error.isNotBlank()){
        Text(text = state.error)
    }

    if(state.isLoading){
        Text(text = "Loading..")
    }

    LazyColumn{
        items(viewModel.uiState.treesList){
            Column {
                TreeItem(onNavigateTo = onDetailClicked, tree = it
                )
            }
        }
    }
}

