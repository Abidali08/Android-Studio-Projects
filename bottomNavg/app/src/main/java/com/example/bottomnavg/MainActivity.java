package com.example.bottomnavg;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btnnavgview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

        btnnavgview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if(id==R.id.nav_home)
                {
                    setFragment(new AFragment(),true);
                }
                else if (id==R.id.nav_contact) {
                    setFragment(new BFragment(),false);
                }
                else if (id==R.id.nav_person) {
                    setFragment(new DFragment(),false);
                }
                else if (id==R.id.nav_search) {
                    setFragment(new EFragment(),false);
                }
                else
                {
                    setFragment(new Fragment(),false);
                }
                return true;
            }
        });

        btnnavgview.setSelectedItemId(R.id.nav_home);
    }
    void init()
    {
        btnnavgview = findViewById(R.id.btnNavgView);
    }

    void setFragment(Fragment fragment,boolean flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag)
        {
            ft.add(R.id.framelayout,fragment);
        }
        else
        {
            ft.replace(R.id.framelayout,fragment);
        }
        ft.commit();
    }
}
