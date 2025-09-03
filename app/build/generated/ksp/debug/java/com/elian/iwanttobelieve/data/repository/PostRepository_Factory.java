package com.elian.iwanttobelieve.data.repository;

import com.elian.iwanttobelieve.data.datasource.PostRemoteDataSource;
import com.elian.iwanttobelieve.data.datasource.UserAuthDataSource;
import com.elian.iwanttobelieve.data.datasource.UserRemoteDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class PostRepository_Factory implements Factory<PostRepository> {
  private final Provider<PostRemoteDataSource> postRemoteProvider;

  private final Provider<UserAuthDataSource> userAuthProvider;

  private final Provider<UserRemoteDataSource> userRemoteProvider;

  private PostRepository_Factory(Provider<PostRemoteDataSource> postRemoteProvider,
      Provider<UserAuthDataSource> userAuthProvider,
      Provider<UserRemoteDataSource> userRemoteProvider) {
    this.postRemoteProvider = postRemoteProvider;
    this.userAuthProvider = userAuthProvider;
    this.userRemoteProvider = userRemoteProvider;
  }

  @Override
  public PostRepository get() {
    return newInstance(postRemoteProvider.get(), userAuthProvider.get(), userRemoteProvider.get());
  }

  public static PostRepository_Factory create(Provider<PostRemoteDataSource> postRemoteProvider,
      Provider<UserAuthDataSource> userAuthProvider,
      Provider<UserRemoteDataSource> userRemoteProvider) {
    return new PostRepository_Factory(postRemoteProvider, userAuthProvider, userRemoteProvider);
  }

  public static PostRepository newInstance(PostRemoteDataSource postRemote,
      UserAuthDataSource userAuth, UserRemoteDataSource userRemote) {
    return new PostRepository(postRemote, userAuth, userRemote);
  }
}
