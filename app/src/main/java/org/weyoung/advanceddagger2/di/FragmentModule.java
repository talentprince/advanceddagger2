package org.weyoung.advanceddagger2.di;

import org.weyoung.advanceddagger2.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragmentInjector();
}
