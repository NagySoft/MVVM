package com.essence.mvvmapplication;

import android.app.Activity;
import android.app.Application;

import com.essence.mvvmapplication.di.ApplicationComponent;
import com.essence.mvvmapplication.di.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MVVMApplication extends Application implements HasActivityInjector {
    public static ApplicationComponent applicationComponent;
    @Inject
    DispatchingAndroidInjector<Activity> androidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.create();
        applicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return androidInjector;
    }
}
