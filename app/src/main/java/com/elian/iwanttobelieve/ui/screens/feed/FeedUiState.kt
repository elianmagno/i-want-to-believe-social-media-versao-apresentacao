package com.elian.iwanttobelieve.ui.screens.feed

import com.elian.iwanttobelieve.ui.model.PostWithAuthor
import com.elian.iwanttobelieve.util.ErrorType

data class FeedUiState (

    val postsWithAuthor : List<PostWithAuthor> = emptyList(),
    val isLoading : Boolean = false,
    val isSuccess : Boolean = false,
    val errorMessage : ErrorType? = null
)