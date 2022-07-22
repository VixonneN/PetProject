package ru.khomichenko.myapplication.main_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.khomochenko.domain.network.entity.PhotoResponseEntity
import ru.khomochenko.domain.network.use_cases.GetListPhotosUseCase
import ru.khomochenko.domain.network.utils.Response
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val getListPhotosUseCase: GetListPhotosUseCase
) : ViewModel() {

    private val _networkState = MutableStateFlow<MainFragmentState>(MainFragmentState.Loading)
    val networkState = _networkState.asStateFlow()

    private val _data = MutableStateFlow<PhotoResponseEntity?>(null)
    val data = _data.asStateFlow()

    fun loadPhotos() {
        viewModelScope.launch {
            getListPhotosUseCase().collect { state ->
                when(state) {
                    is Response.Loading -> {
                        _networkState.value = MainFragmentState.Loading
                    }
                    is Response.Success -> {
                        val response = state._data as PhotoResponseEntity
                        _data.value = response
                        _networkState.value = MainFragmentState.Success
                    }
                    is Response.Error -> {
                        _networkState.value = MainFragmentState.Error
                    }
                }
            }
        }
    }
}