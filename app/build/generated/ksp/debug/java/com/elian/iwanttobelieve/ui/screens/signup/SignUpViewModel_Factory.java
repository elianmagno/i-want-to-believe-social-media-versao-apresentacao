package com.elian.iwanttobelieve.ui.screens.signup;

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
public final class SignUpViewModel_Factory implements Factory<SignUpViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<ErrorMapper> errorMapperProvider;

  private SignUpViewModel_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.errorMapperProvider = errorMapperProvider;
  }

  @Override
  public SignUpViewModel get() {
    return newInstance(userRepositoryProvider.get(), errorMapperProvider.get());
  }

  public static SignUpViewModel_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    return new SignUpViewModel_Factory(userRepositoryProvider, errorMapperProvider);
  }

  public static SignUpViewModel newInstance(UserRepository userRepository,
      ErrorMapper errorMapper) {
    return new SignUpViewModel(userRepository, errorMapper);
  }
}
