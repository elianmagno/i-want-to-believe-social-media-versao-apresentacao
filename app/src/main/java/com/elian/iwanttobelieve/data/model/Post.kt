package com.elian.iwanttobelieve.data.model

import java.util.Date

data class Post (
    val description: String = "",
    val imageUrl: String = "",
    val timestamp: Date = Date(),
    val userId: String = "",
)
