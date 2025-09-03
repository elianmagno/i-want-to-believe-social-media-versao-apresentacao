package com.elian.iwanttobelieve.ui.screens.feed;

import com.elian.iwanttobelieve.data.repository.PostRepository;
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
public final class FeedViewModel_Factory implements Factory<FeedViewModel> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<PostRepository> postRepositoryProvider;

  private final Provider<ErrorMapper> errorMapperProvider;

  private FeedViewModel_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<PostRepository> postRepositoryProvider, Provider<ErrorMapper> errorMapperProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.postRepositoryProvider = postRepositoryProvider;
    this.errorMapperProvider = errorMapperProvider;
  }

  @Override
  public FeedViewModel get() {
    return newInstance(userRepositoryProvider.get(), postRepositoryProvider.get(), errorMapperProvider.get());
  }

  public static FeedViewModel_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<PostRepository> postRepositoryProvider, Provider<ErrorMapper> errorMapperProvider) {
    return new FeedViewModel_Factory(userRepositoryProvider, postRepositoryProvider, errorMapperProvider);
  }

  public static FeedViewModel newInstance(UserRepository userRepository,
      PostRepository postRepository, ErrorMapper errorMapper) {
    return new FeedViewModel(userRepository, postRepository, errorMapper);
  }
}
