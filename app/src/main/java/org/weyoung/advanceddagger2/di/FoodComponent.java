package org.weyoung.advanceddagger2.di;

import org.weyoung.advanceddagger2.model.Food;

import dagger.Component;

@Component(modules = FoodModule.class)
public interface FoodComponent {
    //这个是关键,必须显示指出可以提供Food对象的生成
    Food getFood();
}
