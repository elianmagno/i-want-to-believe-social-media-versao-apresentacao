package com.elian.iwanttobelieve.ui.screens.update;

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
public final class UpdateViewModel_Factory implements Factory<UpdateViewModel> {
  private final Provider<UserRepository> repositoryProvider;

  private final Provider<ErrorMapper> errorMapperProvider;

  private UpdateViewModel_Factory(Provider<UserRepository> repositoryProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    this.repositoryProvider = repositoryProvider;
    this.errorMapperProvider = errorMapperProvider;
  }

  @Override
  public UpdateViewModel get() {
    return newInstance(repositoryProvider.get(), errorMapperProvider.get());
  }

  public static UpdateViewModel_Factory create(Provider<UserRepository> repositoryProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    return new UpdateViewModel_Factory(repositoryProvider, errorMapperProvider);
  }

  public static UpdateViewModel newInstance(UserRepository repository, ErrorMapper errorMapper) {
    return new UpdateViewModel(repository, errorMapper);
  }
}
