package com.elian.iwanttobelieve.data.di;

import com.elian.iwanttobelieve.data.datasource.UserAuthDataSource;
import com.elian.iwanttobelieve.data.datasource.UserRemoteDataSource;
import com.elian.iwanttobelieve.data.repository.UserRepository;
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
public final class RepositoryModule_ProvideUserRepositoryFactory implements Factory<UserRepository> {
  private final Provider<UserAuthDataSource> authDataSourceProvider;

  private final Provider<UserRemoteDataSource> remoteDataSourceProvider;

  private RepositoryModule_ProvideUserRepositoryFactory(
      Provider<UserAuthDataSource> authDataSourceProvider,
      Provider<UserRemoteDataSource> remoteDataSourceProvider) {
    this.authDataSourceProvider = authDataSourceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
  }

  @Override
  public UserRepository get() {
    return provideUserRepository(authDataSourceProvider.get(), remoteDataSourceProvider.get());
  }

  public static RepositoryModule_ProvideUserRepositoryFactory create(
      Provider<UserAuthDataSource> authDataSourceProvider,
      Provider<UserRemoteDataSource> remoteDataSourceProvider) {
    return new RepositoryModule_ProvideUserRepositoryFactory(authDataSourceProvider, remoteDataSourceProvider);
  }

  public static UserRepository provideUserRepository(UserAuthDataSource authDataSource,
      UserRemoteDataSource remoteDataSource) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideUserRepository(authDataSource, remoteDataSource));
  }
}
