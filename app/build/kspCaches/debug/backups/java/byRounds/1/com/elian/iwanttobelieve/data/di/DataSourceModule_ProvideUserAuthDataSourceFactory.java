package com.elian.iwanttobelieve.data.di;

import com.elian.iwanttobelieve.data.datasource.UserAuthDataSource;
import com.google.firebase.auth.FirebaseAuth;
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
public final class DataSourceModule_ProvideUserAuthDataSourceFactory implements Factory<UserAuthDataSource> {
  private final Provider<FirebaseAuth> authProvider;

  private DataSourceModule_ProvideUserAuthDataSourceFactory(Provider<FirebaseAuth> authProvider) {
    this.authProvider = authProvider;
  }

  @Override
  public UserAuthDataSource get() {
    return provideUserAuthDataSource(authProvider.get());
  }

  public static DataSourceModule_ProvideUserAuthDataSourceFactory create(
      Provider<FirebaseAuth> authProvider) {
    return new DataSourceModule_ProvideUserAuthDataSourceFactory(authProvider);
  }

  public static UserAuthDataSource provideUserAuthDataSource(FirebaseAuth auth) {
    return Preconditions.checkNotNullFromProvides(DataSourceModule.INSTANCE.provideUserAuthDataSource(auth));
  }
}
