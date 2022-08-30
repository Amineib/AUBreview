package com.unknown.onepointtest.ui.screens.home

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unknown.onepointtest.common.Resource
import com.unknown.onepointtest.domain.Tree
import com.unknown.onepointtest.domain.TreeRepository
import com.unknown.onepointtest.domain.use_case.GetTreesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val useCase : GetTreesUseCase
) : ViewModel() {

    var uiState by mutableStateOf(TreesUiState())
        private set

    init {
        getTreesList()
    }


    private fun getTreesList(){
        useCase.invoke().onEach {
            when(it){
                is Resource.Success -> {
                    uiState = uiState.copy(
                        treesList = it.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    uiState = uiState.copy(
                        error = it.message ?: "Unexpected error occured.."
                    )
                }
                is Resource.Loading -> {
                    uiState = uiState.copy(isLoading =  true)
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class TreesUiState(
    val isLoading : Boolean = false,
    val treesList : List<Tree> = listOf(),
    val error: String = ""
)