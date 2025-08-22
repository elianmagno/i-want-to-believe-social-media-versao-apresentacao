package com.elian.iwanttobelieve.ui.model

import com.elian.iwanttobelieve.data.model.Post
import com.elian.iwanttobelieve.data.model.User

data class PostWithAuthor (
    val post: Post,
    val author: User?
)