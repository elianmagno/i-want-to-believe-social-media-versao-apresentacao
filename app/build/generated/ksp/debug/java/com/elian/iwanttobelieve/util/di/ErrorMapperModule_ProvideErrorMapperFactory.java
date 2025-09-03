package com.elian.iwanttobelieve.util.di;

import com.elian.iwanttobelieve.util.ErrorMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ErrorMapperModule_ProvideErrorMapperFactory implements Factory<ErrorMapper> {
  @Override
  public ErrorMapper get() {
    return provideErrorMapper();
  }

  public static ErrorMapperModule_ProvideErrorMapperFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ErrorMapper provideErrorMapper() {
    return Preconditions.checkNotNullFromProvides(ErrorMapperModule.INSTANCE.provideErrorMapper());
  }

  private static final class InstanceHolder {
    static final ErrorMapperModule_ProvideErrorMapperFactory INSTANCE = new ErrorMapperModule_ProvideErrorMapperFactory();
  }
}
