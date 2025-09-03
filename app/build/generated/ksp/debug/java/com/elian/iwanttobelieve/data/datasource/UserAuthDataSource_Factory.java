package com.elian.iwanttobelieve.data.datasource;

import com.google.firebase.auth.FirebaseAuth;
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
public final class UserAuthDataSource_Factory implements Factory<UserAuthDataSource> {
  private final Provider<FirebaseAuth> authProvider;

  private UserAuthDataSource_Factory(Provider<FirebaseAuth> authProvider) {
    this.authProvider = authProvider;
  }

  @Override
  public UserAuthDataSource get() {
    return newInstance(authProvider.get());
  }

  public static UserAuthDataSource_Factory create(Provider<FirebaseAuth> authProvider) {
    return new UserAuthDataSource_Factory(authProvider);
  }

  public static UserAuthDataSource newInstance(FirebaseAuth auth) {
    return new UserAuthDataSource(auth);
  }
}
