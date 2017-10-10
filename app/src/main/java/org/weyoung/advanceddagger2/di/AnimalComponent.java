package org.weyoung.advanceddagger2.di;

import org.weyoung.advanceddagger2.MyApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(
        dependencies = FoodComponent.class,
        modules = { AndroidInjectionModule.class,
                AnimalModule.class,
                ActivityModule.class,
                PetModule.class}
)
public interface AnimalComponent {
    void inject(MyApplication myApplication);
}
