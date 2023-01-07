package com.example.a20184355mdp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TimelinePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    TimelineFragment timelineFragment = new TimelineFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    FavouritesFragment favouritesFragment = new FavouritesFragment();
    DiscoverFragment discoverFragment = new DiscoverFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline_page);

        bottomNavigationView  = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,timelineFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.timelineBtn:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,timelineFragment).commit();
                        return true;
                    case R.id.discoverBtn:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,discoverFragment).commit();
                        return true;
                    case R.id.favouritesBtn:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,favouritesFragment).commit();
                        return true;
                    case R.id.settings:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingsFragment).commit();
                        return true;
                }

                return false;
            }
        });
    }
}