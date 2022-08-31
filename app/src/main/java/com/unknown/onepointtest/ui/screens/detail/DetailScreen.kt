package com.unknown.onepointtest.ui.screens.detail

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.unknown.onepointtest.data.local.Dummy
import com.unknown.onepointtest.ui.screens.home.HomeViewModel
import com.unknown.onepointtest.ui.screens.home.TreeItem
import kotlin.random.Random

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    modifier :Modifier = Modifier
) {
    val state = viewModel.uiState
    if(state.error.isNotBlank()){
        Text(text = state.error)
    }

    if(state.loading){
        Text(text = "Loading..")
    }

    Column() {
        viewModel.uiState.data?.let {
            TreeItem(onNavigateTo = {},
                tree = it
            )
        }
        
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "Lorem Ipsum", style = MaterialTheme.typography.h3, modifier = Modifier.padding(start = 16.dp))
        Text(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
            text = Dummy.dummyData.get(Random.nextInt(0, Dummy.dummyData.lastIndex)))
    }
}







