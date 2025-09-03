package com.elian.iwanttobelieve.ui.screens.splash;

import com.elian.iwanttobelieve.data.repository.UserRepository;
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
public final class SplashViewModel_Factory implements Factory<SplashViewModel> {
  private final Provider<UserRepository> repositoryProvider;

  private SplashViewModel_Factory(Provider<UserRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SplashViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static SplashViewModel_Factory create(Provider<UserRepository> repositoryProvider) {
    return new SplashViewModel_Factory(repositoryProvider);
  }

  public static SplashViewModel newInstance(UserRepository repository) {
    return new SplashViewModel(repository);
  }
}
