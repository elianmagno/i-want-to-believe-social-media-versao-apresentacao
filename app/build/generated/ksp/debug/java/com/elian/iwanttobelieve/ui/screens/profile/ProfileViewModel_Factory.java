package com.elian.iwanttobelieve.ui.screens.profile;

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
public final class ProfileViewModel_Factory implements Factory<ProfileViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<ErrorMapper> errorMapperProvider;

  private ProfileViewModel_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.errorMapperProvider = errorMapperProvider;
  }

  @Override
  public ProfileViewModel get() {
    return newInstance(userRepositoryProvider.get(), errorMapperProvider.get());
  }

  public static ProfileViewModel_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    return new ProfileViewModel_Factory(userRepositoryProvider, errorMapperProvider);
  }

  public static ProfileViewModel newInstance(UserRepository userRepository,
      ErrorMapper errorMapper) {
    return new ProfileViewModel(userRepository, errorMapper);
  }
}
