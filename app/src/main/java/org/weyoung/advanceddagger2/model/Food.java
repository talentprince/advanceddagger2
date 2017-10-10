package org.weyoung.advanceddagger2.model;

import android.util.Log;

import javax.inject.Inject;

public class Food {
    @Inject
    public Food() {
        Log.i("dagger", "create food " + hashCode());
    }
}
