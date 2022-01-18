package com.example.edt32;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);

        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        settingsFragment = new SettingsFragment();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //return false;
                switch (item.getItemId()) {
                    case R.id.nav_home://open the HomeFragment        //We can change the color of the background using the following:
                        setFragment(homeFragment);
                        mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);
                        return true;
                    case R.id.nav_profile:
                        //open the Profile

                        mMainNav.setItemBackgroundResource(R.color.design_default_color_primary);
                        setFragment(profileFragment);

                        return true;
                    case R.id.nav_settings://open the Settings
                        mMainNav.setItemBackgroundResource(R.color.design_default_color_secondary);
                        setFragment(settingsFragment);

                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}