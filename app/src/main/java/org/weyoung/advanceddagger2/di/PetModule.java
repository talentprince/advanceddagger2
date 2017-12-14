package org.weyoung.advanceddagger2.di;

import org.weyoung.advanceddagger2.model.Dog;
import org.weyoung.advanceddagger2.model.Pet;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetModule {
    @Binds
    public abstract Pet bindPet(Dog dog);
}
