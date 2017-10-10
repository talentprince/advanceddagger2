package org.weyoung.advanceddagger2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.weyoung.advanceddagger2.di.CatComponent;
import org.weyoung.advanceddagger2.model.Animal;
import org.weyoung.advanceddagger2.model.Cat;
import org.weyoung.advanceddagger2.model.Dog;
import org.weyoung.advanceddagger2.model.Pet;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    Animal animal;
    @Inject
    Lazy<Dog> dog;
    @Inject
    Pet pet;
    @Inject
    CatComponent catComponent;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    Provider<Cat> cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dog.get();
        dog.get();

        cat = catComponent.cat();

        cat.get();
        cat.get();

        Button button = findViewById(R.id.open_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.content, new MainFragment())
                        .addToBackStack("fragment")
                        .commit();
            }
        });
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
