package com.elian.iwanttobelieve;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.elian.iwanttobelieve.data.datasource.PostRemoteDataSource;
import com.elian.iwanttobelieve.data.datasource.UserAuthDataSource;
import com.elian.iwanttobelieve.data.datasource.UserRemoteDataSource;
import com.elian.iwanttobelieve.data.di.DataSourceModule_ProvidePostRemoteDataSourceFactory;
import com.elian.iwanttobelieve.data.di.DataSourceModule_ProvideUserAuthDataSourceFactory;
import com.elian.iwanttobelieve.data.di.DataSourceModule_ProvideUserRemoteDataSourceFactory;
import com.elian.iwanttobelieve.data.di.FirebaseModule_ProvideAuthFactory;
import com.elian.iwanttobelieve.data.di.FirebaseModule_ProvideFirestoreFactory;
import com.elian.iwanttobelieve.data.di.FirebaseModule_ProvideStorageFactory;
import com.elian.iwanttobelieve.data.di.RepositoryModule_ProvidePostRepositoryFactory;
import com.elian.iwanttobelieve.data.di.RepositoryModule_ProvideUserRepositoryFactory;
import com.elian.iwanttobelieve.data.repository.PostRepository;
import com.elian.iwanttobelieve.data.repository.UserRepository;
import com.elian.iwanttobelieve.ui.screens.feed.FeedViewModel;
import com.elian.iwanttobelieve.ui.screens.feed.FeedViewModel_HiltModules;
import com.elian.iwanttobelieve.ui.screens.feed.FeedViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.feed.FeedViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.post.PostViewModel;
import com.elian.iwanttobelieve.ui.screens.post.PostViewModel_HiltModules;
import com.elian.iwanttobelieve.ui.screens.post.PostViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.post.PostViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.profile.ProfileViewModel;
import com.elian.iwanttobelieve.ui.screens.profile.ProfileViewModel_HiltModules;
import com.elian.iwanttobelieve.ui.screens.profile.ProfileViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.profile.ProfileViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.signin.SignInViewModel;
import com.elian.iwanttobelieve.ui.screens.signin.SignInViewModel_HiltModules;
import com.elian.iwanttobelieve.ui.screens.signin.SignInViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.signin.SignInViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.signup.SignUpViewModel;
import com.elian.iwanttobelieve.ui.screens.signup.SignUpViewModel_HiltModules;
import com.elian.iwanttobelieve.ui.screens.signup.SignUpViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.signup.SignUpViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.splash.SplashViewModel;
import com.elian.iwanttobelieve.ui.screens.splash.SplashViewModel_HiltModules;
import com.elian.iwanttobelieve.ui.screens.splash.SplashViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.splash.SplashViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.update.UpdateViewModel;
import com.elian.iwanttobelieve.ui.screens.update.UpdateViewModel_HiltModules;
import com.elian.iwanttobelieve.ui.screens.update.UpdateViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.elian.iwanttobelieve.ui.screens.update.UpdateViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.elian.iwanttobelieve.util.di.ErrorMapperModule_ProvideErrorMapperFactory;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerIWantToBelieveApp_HiltComponents_SingletonC {
  private DaggerIWantToBelieveApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static IWantToBelieveApp_HiltComponents.SingletonC create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public IWantToBelieveApp_HiltComponents.SingletonC build() {
      return new SingletonCImpl();
    }
  }

  private static final class ActivityRetainedCBuilder implements IWantToBelieveApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public IWantToBelieveApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements IWantToBelieveApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public IWantToBelieveApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements IWantToBelieveApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public IWantToBelieveApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements IWantToBelieveApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public IWantToBelieveApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements IWantToBelieveApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public IWantToBelieveApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements IWantToBelieveApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public IWantToBelieveApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements IWantToBelieveApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public IWantToBelieveApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends IWantToBelieveApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends IWantToBelieveApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    FragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends IWantToBelieveApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends IWantToBelieveApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>builderWithExpectedSize(7).put(FeedViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, FeedViewModel_HiltModules.KeyModule.provide()).put(PostViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, PostViewModel_HiltModules.KeyModule.provide()).put(ProfileViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, ProfileViewModel_HiltModules.KeyModule.provide()).put(SignInViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SignInViewModel_HiltModules.KeyModule.provide()).put(SignUpViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SignUpViewModel_HiltModules.KeyModule.provide()).put(SplashViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, SplashViewModel_HiltModules.KeyModule.provide()).put(UpdateViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, UpdateViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends IWantToBelieveApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    Provider<FeedViewModel> feedViewModelProvider;

    Provider<PostViewModel> postViewModelProvider;

    Provider<ProfileViewModel> profileViewModelProvider;

    Provider<SignInViewModel> signInViewModelProvider;

    Provider<SignUpViewModel> signUpViewModelProvider;

    Provider<SplashViewModel> splashViewModelProvider;

    Provider<UpdateViewModel> updateViewModelProvider;

    ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.feedViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.postViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.profileViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.signInViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.signUpViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.splashViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.updateViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>builderWithExpectedSize(7).put(FeedViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (feedViewModelProvider))).put(PostViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (postViewModelProvider))).put(ProfileViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (profileViewModelProvider))).put(SignInViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (signInViewModelProvider))).put(SignUpViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (signUpViewModelProvider))).put(SplashViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (splashViewModelProvider))).put(UpdateViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, ((Provider) (updateViewModelProvider))).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // com.elian.iwanttobelieve.ui.screens.feed.FeedViewModel
          return (T) new FeedViewModel(singletonCImpl.provideUserRepositoryProvider.get(), singletonCImpl.providePostRepositoryProvider.get(), ErrorMapperModule_ProvideErrorMapperFactory.provideErrorMapper());

          case 1: // com.elian.iwanttobelieve.ui.screens.post.PostViewModel
          return (T) new PostViewModel(singletonCImpl.providePostRepositoryProvider.get(), singletonCImpl.provideUserRepositoryProvider.get(), ErrorMapperModule_ProvideErrorMapperFactory.provideErrorMapper());

          case 2: // com.elian.iwanttobelieve.ui.screens.profile.ProfileViewModel
          return (T) new ProfileViewModel(singletonCImpl.provideUserRepositoryProvider.get(), ErrorMapperModule_ProvideErrorMapperFactory.provideErrorMapper());

          case 3: // com.elian.iwanttobelieve.ui.screens.signin.SignInViewModel
          return (T) new SignInViewModel(singletonCImpl.provideUserRepositoryProvider.get(), ErrorMapperModule_ProvideErrorMapperFactory.provideErrorMapper());

          case 4: // com.elian.iwanttobelieve.ui.screens.signup.SignUpViewModel
          return (T) new SignUpViewModel(singletonCImpl.provideUserRepositoryProvider.get(), ErrorMapperModule_ProvideErrorMapperFactory.provideErrorMapper());

          case 5: // com.elian.iwanttobelieve.ui.screens.splash.SplashViewModel
          return (T) new SplashViewModel(singletonCImpl.provideUserRepositoryProvider.get());

          case 6: // com.elian.iwanttobelieve.ui.screens.update.UpdateViewModel
          return (T) new UpdateViewModel(singletonCImpl.provideUserRepositoryProvider.get(), ErrorMapperModule_ProvideErrorMapperFactory.provideErrorMapper());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends IWantToBelieveApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends IWantToBelieveApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends IWantToBelieveApp_HiltComponents.SingletonC {
    private final SingletonCImpl singletonCImpl = this;

    Provider<FirebaseAuth> provideAuthProvider;

    Provider<UserAuthDataSource> provideUserAuthDataSourceProvider;

    Provider<FirebaseFirestore> provideFirestoreProvider;

    Provider<FirebaseStorage> provideStorageProvider;

    Provider<UserRemoteDataSource> provideUserRemoteDataSourceProvider;

    Provider<UserRepository> provideUserRepositoryProvider;

    Provider<PostRemoteDataSource> providePostRemoteDataSourceProvider;

    Provider<PostRepository> providePostRepositoryProvider;

    SingletonCImpl() {

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideAuthProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseAuth>(singletonCImpl, 2));
      this.provideUserAuthDataSourceProvider = DoubleCheck.provider(new SwitchingProvider<UserAuthDataSource>(singletonCImpl, 1));
      this.provideFirestoreProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseFirestore>(singletonCImpl, 4));
      this.provideStorageProvider = DoubleCheck.provider(new SwitchingProvider<FirebaseStorage>(singletonCImpl, 5));
      this.provideUserRemoteDataSourceProvider = DoubleCheck.provider(new SwitchingProvider<UserRemoteDataSource>(singletonCImpl, 3));
      this.provideUserRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<UserRepository>(singletonCImpl, 0));
      this.providePostRemoteDataSourceProvider = DoubleCheck.provider(new SwitchingProvider<PostRemoteDataSource>(singletonCImpl, 7));
      this.providePostRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<PostRepository>(singletonCImpl, 6));
    }

    @Override
    public void injectIWantToBelieveApp(IWantToBelieveApp arg0) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @Override
      @SuppressWarnings("unchecked")
      public T get() {
        switch (id) {
          case 0: // com.elian.iwanttobelieve.data.repository.UserRepository
          return (T) RepositoryModule_ProvideUserRepositoryFactory.provideUserRepository(singletonCImpl.provideUserAuthDataSourceProvider.get(), singletonCImpl.provideUserRemoteDataSourceProvider.get());

          case 1: // com.elian.iwanttobelieve.data.datasource.UserAuthDataSource
          return (T) DataSourceModule_ProvideUserAuthDataSourceFactory.provideUserAuthDataSource(singletonCImpl.provideAuthProvider.get());

          case 2: // com.google.firebase.auth.FirebaseAuth
          return (T) FirebaseModule_ProvideAuthFactory.provideAuth();

          case 3: // com.elian.iwanttobelieve.data.datasource.UserRemoteDataSource
          return (T) DataSourceModule_ProvideUserRemoteDataSourceFactory.provideUserRemoteDataSource(singletonCImpl.provideFirestoreProvider.get(), singletonCImpl.provideStorageProvider.get());

          case 4: // com.google.firebase.firestore.FirebaseFirestore
          return (T) FirebaseModule_ProvideFirestoreFactory.provideFirestore();

          case 5: // com.google.firebase.storage.FirebaseStorage
          return (T) FirebaseModule_ProvideStorageFactory.provideStorage();

          case 6: // com.elian.iwanttobelieve.data.repository.PostRepository
          return (T) RepositoryModule_ProvidePostRepositoryFactory.providePostRepository(singletonCImpl.providePostRemoteDataSourceProvider.get(), singletonCImpl.provideUserAuthDataSourceProvider.get(), singletonCImpl.provideUserRemoteDataSourceProvider.get());

          case 7: // com.elian.iwanttobelieve.data.datasource.PostRemoteDataSource
          return (T) DataSourceModule_ProvidePostRemoteDataSourceFactory.providePostRemoteDataSource(singletonCImpl.provideFirestoreProvider.get(), singletonCImpl.provideStorageProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
