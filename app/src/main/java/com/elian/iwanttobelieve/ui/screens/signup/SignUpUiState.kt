package com.elian.iwanttobelieve.ui.screens.signup

import com.elian.iwanttobelieve.util.ErrorType

data class SignUpUiState (
    val isLoading : Boolean = false,
    val isSuccess : Boolean = false,
    val errorMessage : ErrorType? = null
)