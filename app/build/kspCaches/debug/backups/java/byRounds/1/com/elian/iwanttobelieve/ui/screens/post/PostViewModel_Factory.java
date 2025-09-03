package com.elian.iwanttobelieve.ui.screens.post;

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
public final class PostViewModel_Factory implements Factory<PostViewModel> {
  private final Provider<PostRepository> postRepositoryProvider;

  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<ErrorMapper> errorMapperProvider;

  private PostViewModel_Factory(Provider<PostRepository> postRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider, Provider<ErrorMapper> errorMapperProvider) {
    this.postRepositoryProvider = postRepositoryProvider;
    this.userRepositoryProvider = userRepositoryProvider;
    this.errorMapperProvider = errorMapperProvider;
  }

  @Override
  public PostViewModel get() {
    return newInstance(postRepositoryProvider.get(), userRepositoryProvider.get(), errorMapperProvider.get());
  }

  public static PostViewModel_Factory create(Provider<PostRepository> postRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider, Provider<ErrorMapper> errorMapperProvider) {
    return new PostViewModel_Factory(postRepositoryProvider, userRepositoryProvider, errorMapperProvider);
  }

  public static PostViewModel newInstance(PostRepository postRepository,
      UserRepository userRepository, ErrorMapper errorMapper) {
    return new PostViewModel(postRepository, userRepository, errorMapper);
  }
}
