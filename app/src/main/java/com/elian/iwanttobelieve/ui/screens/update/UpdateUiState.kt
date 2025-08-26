package com.elian.iwanttobelieve.ui.screens.update

import com.elian.iwanttobelieve.data.model.User
import com.elian.iwanttobelieve.util.ErrorType

data class UpdateUiState (
    val user: User? = null,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: ErrorType? = null
)