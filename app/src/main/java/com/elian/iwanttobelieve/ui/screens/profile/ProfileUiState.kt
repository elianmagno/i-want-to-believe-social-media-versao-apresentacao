package com.elian.iwanttobelieve.ui.screens.profile

import com.elian.iwanttobelieve.data.model.User
import com.elian.iwanttobelieve.util.ErrorType

data class ProfileUiState (
    val user: User? = null,
    val isLoading : Boolean = false,
    val isSuccess : Boolean = false,
    val errorMessage : ErrorType? = null,
    val successMessage : String? = null
)