package com.example.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView btmnavview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btmnavview=findViewById(R.id.bottomnav);

        btmnavview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();

                if(id==R.id.nav_home){
                    loadfrag(new A(),false);

                }else if(id==R.id.nav_search){
                    loadfrag(new B(),false);

                }else if(id==R.id.nav_utility){
                    loadfrag(new C(),false);

                }else if(id==R.id.nav_contacts){
                    loadfrag(new D(),false);

                }else{//profile
                    loadfrag(new E(),true);

                }

                return true;
            }
        });
        btmnavview.setSelectedItemId(R.id.nav_profile);
    }

    public void loadfrag(Fragment fragment,boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
//        ft.add(androidx.core.R.id.action_container,fragment);
        if(flag)
            ft.add(R.id.frame,fragment);
        else {
            ft.replace(R.id.frame,fragment);
        }
        ft.commit();
    }
}
