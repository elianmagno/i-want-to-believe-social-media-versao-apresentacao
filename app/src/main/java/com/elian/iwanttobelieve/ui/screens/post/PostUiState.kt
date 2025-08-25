package com.elian.iwanttobelieve.ui.screens.post

import com.elian.iwanttobelieve.data.model.User
import com.elian.iwanttobelieve.util.ErrorType

data class PostUiState (
    val user : User? = null,
    val isLoading : Boolean = false,
    val isSuccess : Boolean = false,
    val errorMessage : ErrorType? = null
)