package org.weyoung.advanceddagger2.model;

import android.util.Log;

public class Animal {
    public Animal(Food food) {
        Log.i("dagger", "create animal " + hashCode());
    }
}
