package org.weyoung.advanceddagger2.model;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

public class Dog implements Pet {
    @Inject
    public Dog(Leg leg) {
        Log.i("dagger", "create dog " + " " + hashCode());
    }

    @Override
    public void lovely() {

    }
}
