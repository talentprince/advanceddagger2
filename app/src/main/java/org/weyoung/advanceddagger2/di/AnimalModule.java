package org.weyoung.advanceddagger2.di;

import org.weyoung.advanceddagger2.model.Animal;
import org.weyoung.advanceddagger2.model.Food;
import org.weyoung.advanceddagger2.model.Leg;
import org.weyoung.advanceddagger2.model.Tooth;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = CatComponent.class)
class AnimalModule {
    @Provides
    public Animal providesAnimal(Food food) {
        //Animal需要另外一个Component提供的Food来创建
        return new Animal(food);
    }

    @Provides
    public Leg providesLeg() {
        return new Leg();
    }

    @Provides
    public CatComponent providesCat(CatComponent.Builder builder) {
        return builder.tooth(new Tooth()).build();
    }
}
