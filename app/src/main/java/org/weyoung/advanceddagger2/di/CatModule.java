package org.weyoung.advanceddagger2.di;

import org.weyoung.advanceddagger2.model.Cat;
import org.weyoung.advanceddagger2.model.Tooth;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class CatModule {
    @Provides
    @Singleton
    public Cat providesCat(Tooth tooth) {
        return new Cat(tooth);
    }
}
