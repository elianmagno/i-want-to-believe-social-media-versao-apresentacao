package com.elian.iwanttobelieve.ui.screens.update

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elian.iwanttobelieve.data.repository.UserRepository
import com.elian.iwanttobelieve.util.ErrorMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(
    private val repository: UserRepository,
    private val errorMapper: ErrorMapper
): ViewModel() {

    private val _uiState = MutableStateFlow(UpdateUiState())
    val uiState: StateFlow<UpdateUiState> = _uiState.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<Unit>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    init {
        getCurrentUser()
    }

    fun getCurrentUser() {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true, isSuccess = false, errorMessage = null)
                val result = repository.getCurrentUser()

                if (result.isSuccess) {
                    val user = result.getOrNull()
                    _uiState.value = _uiState.value.copy(user = user, isLoading = false, isSuccess = true)
                } else {
                    val errorType = errorMapper.map(result.exceptionOrNull())
                    _uiState.value = _uiState.value.copy(errorMessage = errorType, isLoading = false)
                }
            } catch (e: Exception) {
                val errorType = errorMapper.map(e)
                _uiState.value = _uiState.value.copy(errorMessage = errorType, isLoading = false)
            }
        }
    }

    fun updateUser(email: String, name: String, password: String, newPassword: String) {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true, isSuccess = false, errorMessage = null)

                val result = repository.updateUser(email, name, password, newPassword)

                if(result.isSuccess) {
                    _uiState.value = _uiState.value.copy(isLoading = false, isSuccess = true)

                    _navigationEvent.emit(Unit)
                } else {
                    val errorType = errorMapper.map(result.exceptionOrNull())
                    _uiState.value = _uiState.value.copy(errorMessage = errorType, isLoading = false)

                }
            } catch (e: Exception) {

            }
        }
    }

}