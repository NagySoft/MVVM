package com.essence.mvvmapplication.di;

import com.essence.mvvmapplication.MVVMApplication;
import com.essence.mvvmapplication.di.post.PostComponent;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        NetworkModule.class,
        SubComponentsModule.class})
public interface ApplicationComponent {
    void inject(MVVMApplication application);

    PostComponent.Builder postsComponent();
}