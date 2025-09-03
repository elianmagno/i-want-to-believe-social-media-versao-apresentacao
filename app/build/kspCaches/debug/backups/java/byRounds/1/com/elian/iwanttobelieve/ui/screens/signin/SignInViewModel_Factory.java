package com.elian.iwanttobelieve.ui.screens.signin;

import com.elian.iwanttobelieve.data.repository.UserRepository;
import com.elian.iwanttobelieve.util.ErrorMapper;
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
public final class SignInViewModel_Factory implements Factory<SignInViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<ErrorMapper> errorMapperProvider;

  private SignInViewModel_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.errorMapperProvider = errorMapperProvider;
  }

  @Override
  public SignInViewModel get() {
    return newInstance(userRepositoryProvider.get(), errorMapperProvider.get());
  }

  public static SignInViewModel_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    return new SignInViewModel_Factory(userRepositoryProvider, errorMapperProvider);
  }

  public static SignInViewModel newInstance(UserRepository userRepository,
      ErrorMapper errorMapper) {
    return new SignInViewModel(userRepository, errorMapper);
  }
}
