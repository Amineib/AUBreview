package com.unknown.onepointtest.ui.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unknown.onepointtest.common.Resource
import com.unknown.onepointtest.domain.Tree
import com.unknown.onepointtest.domain.use_case.GetTreeDetailUseCase
import com.unknown.onepointtest.ui.screens.home.TreesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase : GetTreeDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    var uiState by mutableStateOf(DetailUiState())
        private set


    init {
       savedStateHandle.get<String>("id")?.let {
           getDetails(it)
       }
    }

    private fun getDetails(id: String){
        useCase.invoke(id).onEach {
            when(it){
                is Resource.Success -> {
                    uiState = uiState.copy(
                        data = it.data,
                        loading = false
                    )
                }
                is Resource.Error -> {
                    uiState = uiState.copy(
                        error = it.message ?: "Unexpected error occured.."
                    )
                }
                is Resource.Loading -> {
                    uiState = uiState.copy(loading =  true)
                }
            }
        }.launchIn(viewModelScope)
    }

}




data class DetailUiState(
    val loading : Boolean = false,
    val data : Tree? = null,
    val error : String = ""
)