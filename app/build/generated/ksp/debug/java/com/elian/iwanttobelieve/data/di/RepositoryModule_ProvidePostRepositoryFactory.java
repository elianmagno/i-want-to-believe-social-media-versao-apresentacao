package com.elian.iwanttobelieve.data.di;

import com.elian.iwanttobelieve.data.datasource.PostRemoteDataSource;
import com.elian.iwanttobelieve.data.datasource.UserAuthDataSource;
import com.elian.iwanttobelieve.data.datasource.UserRemoteDataSource;
import com.elian.iwanttobelieve.data.repository.PostRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class RepositoryModule_ProvidePostRepositoryFactory implements Factory<PostRepository> {
  private final Provider<PostRemoteDataSource> postDataSourceProvider;

  private final Provider<UserAuthDataSource> authDataSourceProvider;

  private final Provider<UserRemoteDataSource> userDataSourceProvider;

  private RepositoryModule_ProvidePostRepositoryFactory(
      Provider<PostRemoteDataSource> postDataSourceProvider,
      Provider<UserAuthDataSource> authDataSourceProvider,
      Provider<UserRemoteDataSource> userDataSourceProvider) {
    this.postDataSourceProvider = postDataSourceProvider;
    this.authDataSourceProvider = authDataSourceProvider;
    this.userDataSourceProvider = userDataSourceProvider;
  }

  @Override
  public PostRepository get() {
    return providePostRepository(postDataSourceProvider.get(), authDataSourceProvider.get(), userDataSourceProvider.get());
  }

  public static RepositoryModule_ProvidePostRepositoryFactory create(
      Provider<PostRemoteDataSource> postDataSourceProvider,
      Provider<UserAuthDataSource> authDataSourceProvider,
      Provider<UserRemoteDataSource> userDataSourceProvider) {
    return new RepositoryModule_ProvidePostRepositoryFactory(postDataSourceProvider, authDataSourceProvider, userDataSourceProvider);
  }

  public static PostRepository providePostRepository(PostRemoteDataSource postDataSource,
      UserAuthDataSource authDataSource, UserRemoteDataSource userDataSource) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.providePostRepository(postDataSource, authDataSource, userDataSource));
  }
}
