package com.elian.iwanttobelieve.data.di

import com.elian.iwanttobelieve.data.datasource.PostRemoteDataSource
import com.elian.iwanttobelieve.data.datasource.UserAuthDataSource
import com.elian.iwanttobelieve.data.datasource.UserRemoteDataSource
import com.elian.iwanttobelieve.data.repository.PostRepository
import com.elian.iwanttobelieve.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        authDataSource: UserAuthDataSource,
        remoteDataSource: UserRemoteDataSource
    ): UserRepository {
        return UserRepository(authDataSource, remoteDataSource)
    }

    @Provides
    @Singleton
    fun providePostRepository(
        postDataSource: PostRemoteDataSource,
        authDataSource: UserAuthDataSource,
        userDataSource: UserRemoteDataSource
    ): PostRepository {
        return PostRepository(postDataSource, authDataSource, userDataSource)
    }
}
