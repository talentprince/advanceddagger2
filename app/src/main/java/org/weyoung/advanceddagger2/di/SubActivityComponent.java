package org.weyoung.advanceddagger2.di;

/**
 * Created by chenchen on 30/10/2017.
 */

import org.weyoung.advanceddagger2.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface SubActivityComponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
