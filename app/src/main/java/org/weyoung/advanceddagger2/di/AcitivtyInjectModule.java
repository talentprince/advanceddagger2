package org.weyoung.advanceddagger2.di;


import android.app.Activity;

import org.weyoung.advanceddagger2.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = SubActivityComponent.class)
public abstract class AcitivtyInjectModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(SubActivityComponent.Builder builder);
}
