package com.elian.iwanttobelieve.data.di;

import com.elian.iwanttobelieve.data.datasource.UserRemoteDataSource;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
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
public final class DataSourceModule_ProvideUserRemoteDataSourceFactory implements Factory<UserRemoteDataSource> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<FirebaseStorage> storageProvider;

  private DataSourceModule_ProvideUserRemoteDataSourceFactory(
      Provider<FirebaseFirestore> firestoreProvider, Provider<FirebaseStorage> storageProvider) {
    this.firestoreProvider = firestoreProvider;
    this.storageProvider = storageProvider;
  }

  @Override
  public UserRemoteDataSource get() {
    return provideUserRemoteDataSource(firestoreProvider.get(), storageProvider.get());
  }

  public static DataSourceModule_ProvideUserRemoteDataSourceFactory create(
      Provider<FirebaseFirestore> firestoreProvider, Provider<FirebaseStorage> storageProvider) {
    return new DataSourceModule_ProvideUserRemoteDataSourceFactory(firestoreProvider, storageProvider);
  }

  public static UserRemoteDataSource provideUserRemoteDataSource(FirebaseFirestore firestore,
      FirebaseStorage storage) {
    return Preconditions.checkNotNullFromProvides(DataSourceModule.INSTANCE.provideUserRemoteDataSource(firestore, storage));
  }
}
