package com.elian.iwanttobelieve.data.datasource

import com.elian.iwanttobelieve.data.model.Post
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.snapshots
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage
) {
    suspend fun uploadPostImage(userId: String, image: ByteArray): String {
        val path = "posts/$userId/${System.currentTimeMillis()}.jpg"

        val reference = storage.reference.child(path)

        reference.putBytes(image).await()

        return reference.downloadUrl.await()?.toString()
            ?: throw IllegalStateException("Image not saved successfully.")
    }

    suspend fun createPost(userId: String, post: Post): String {
       val post = firestore.collection("posts")
           .add(post)
           .await()

       return post.id
    }

    fun observePostsByTimestamp(): Flow<List<Post>> {
        val query: Query = firestore.collection("posts")
            .orderBy("timestamp", Query.Direction.DESCENDING)

        val postListFlow = query.snapshots()
            .map { qs ->
                qs.toObjects(Post::class.java)
            }

        return postListFlow
    }
}