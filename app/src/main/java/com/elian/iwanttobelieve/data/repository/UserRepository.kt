package com.elian.iwanttobelieve.data.repository

import com.elian.iwanttobelieve.data.datasource.UserAuthDataSource
import com.elian.iwanttobelieve.data.datasource.UserRemoteDataSource
import com.elian.iwanttobelieve.data.model.User

class UserRepository(
    private val auth: UserAuthDataSource,
    private val remote: UserRemoteDataSource
) {

    fun isUserLoggedIn(): Result<Boolean> {
        return try {
            val result = auth.isUserLoggedIn()
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    suspend fun createUser(email: String, name: String, password: String): Result<Unit>  {
        return try {
            val uid = auth.signUp(email, password)
            val user = User(uid, email, name)
            remote.createUser(uid, user)

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun signIn(email: String, password: String): Result<Unit> {
        return try {
            auth.signIn(email, password)

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun signOut(): Result<Unit> {
        return try {
            auth.signOut()

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    suspend fun setUserImage(image: ByteArray): Result<Unit> {
        return try {
            val uid = auth.getCurrentUserId()

            remote.setUserImage(uid, image)

            val url = remote.getUserImageUrl(uid)

            remote.updateUser(uid, mapOf("imageUrl" to url))

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getCurrentUser(): Result<User> {
        return try {
            val uid = auth.getCurrentUserId()
            val user = remote.getUser(uid)

            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getUsersByIds(userIds: List<String>): Result<Map<String, User>> {
        return try {
            val map = remote.getUsersByIds(userIds)

            Result.success(map)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateUser(email: String, name: String, password: String, newPassword: String ): Result<Unit> {
        return try {
            auth.reauthenticateWithPassword(password)

            auth.updateEmail(email)
            auth.updatePassword(newPassword)

            val uid = auth.getCurrentUserId()
            val result = remote.updateUser(uid, mapOf("email" to email, "name" to name) )

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}