package org.weyoung.advanceddagger2.di;


import org.weyoung.advanceddagger2.model.Cat;
import org.weyoung.advanceddagger2.model.Tooth;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = CatModule.class)
public interface CatComponent {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        Builder tooth(Tooth tooth);
        CatComponent build();
    }

    Provider<Cat> cat();
}
