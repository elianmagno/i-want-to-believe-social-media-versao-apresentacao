package com.elian.iwanttobelieve.ui.screens.signin

import com.elian.iwanttobelieve.util.ErrorType

data class SignInUiState (
    val isLoading : Boolean = false,
    val isSuccess : Boolean = false,
    val errorMessage : ErrorType? = null
)