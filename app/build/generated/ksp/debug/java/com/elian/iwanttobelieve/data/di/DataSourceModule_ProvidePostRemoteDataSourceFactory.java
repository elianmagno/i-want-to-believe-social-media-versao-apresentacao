package com.elian.iwanttobelieve.data.di;

import com.elian.iwanttobelieve.data.datasource.PostRemoteDataSource;
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
public final class DataSourceModule_ProvidePostRemoteDataSourceFactory implements Factory<PostRemoteDataSource> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<FirebaseStorage> storageProvider;

  private DataSourceModule_ProvidePostRemoteDataSourceFactory(
      Provider<FirebaseFirestore> firestoreProvider, Provider<FirebaseStorage> storageProvider) {
    this.firestoreProvider = firestoreProvider;
    this.storageProvider = storageProvider;
  }

  @Override
  public PostRemoteDataSource get() {
    return providePostRemoteDataSource(firestoreProvider.get(), storageProvider.get());
  }

  public static DataSourceModule_ProvidePostRemoteDataSourceFactory create(
      Provider<FirebaseFirestore> firestoreProvider, Provider<FirebaseStorage> storageProvider) {
    return new DataSourceModule_ProvidePostRemoteDataSourceFactory(firestoreProvider, storageProvider);
  }

  public static PostRemoteDataSource providePostRemoteDataSource(FirebaseFirestore firestore,
      FirebaseStorage storage) {
    return Preconditions.checkNotNullFromProvides(DataSourceModule.INSTANCE.providePostRemoteDataSource(firestore, storage));
  }
}
