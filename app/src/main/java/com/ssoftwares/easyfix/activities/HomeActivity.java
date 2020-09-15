package com.ssoftwares.easyfix.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.ssoftwares.easyfix.R;
import com.ssoftwares.easyfix.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    private final Fragment homeFragment = new HomeFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFragment;
    Context mContext;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext = HomeActivity.this;

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        LoadFragment(homeFragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.home:
                    active = homeFragment;
                    break;
                case R.id.order:
                    active = homeFragment;
                    break;
                case R.id.cart:
                    active = homeFragment;
                    break;
                case R.id.profile:
                    active = homeFragment;
                    break;


            }

            return LoadFragment(active);
        }
    };

    private boolean LoadFragment(Fragment fragment) {
        active = fragment;
        if (fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            // bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

            return true;
        }
        return false;
    }
}