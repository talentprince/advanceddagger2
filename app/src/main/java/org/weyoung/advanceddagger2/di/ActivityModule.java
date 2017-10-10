package org.weyoung.advanceddagger2.di;

import org.weyoung.advanceddagger2.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivityInjector();
}
