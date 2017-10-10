package org.weyoung.advanceddagger2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import org.weyoung.advanceddagger2.di.AnimalComponent;
import org.weyoung.advanceddagger2.di.DaggerAnimalComponent;
import org.weyoung.advanceddagger2.di.DaggerFoodComponent;
import org.weyoung.advanceddagger2.di.FoodComponent;
import org.weyoung.advanceddagger2.di.Injectable;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;


public class MyApplication extends Application implements HasActivityInjector{

    private FoodComponent foodComponent;
    private AnimalComponent animalComponent;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        foodComponent = DaggerFoodComponent.create();
        animalComponent = DaggerAnimalComponent.builder().foodComponent(foodComponent).build();
        animalComponent.inject(this);

        autoInjectRegister();
    }

    private void autoInjectRegister() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof HasSupportFragmentInjector) {
                    AndroidInjection.inject(activity);
                }
                if (activity instanceof FragmentActivity) {
                    ((FragmentActivity) activity).getSupportFragmentManager()
                            .registerFragmentLifecycleCallbacks(
                                    new FragmentManager.FragmentLifecycleCallbacks() {
                                        @Override
                                        public void onFragmentCreated(FragmentManager fm, Fragment f,
                                                                      Bundle savedInstanceState) {
                                            if (f instanceof Injectable) {
                                                AndroidSupportInjection.inject(f);
                                            }
                                        }
                                    }, true);
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
