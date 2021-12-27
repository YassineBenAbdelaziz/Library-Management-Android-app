/*
Data activity java file , sets the tablayout params and creates the fragment manager upon 
creating this activity.
*/




package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;


public class data_activity extends AppCompatActivity {


    TabLayout tablayout ;
    ViewPager2 pager ;
    FragAdapter fragAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_activity);

        tablayout = findViewById(R.id.tabs);
        pager =  findViewById(R.id.viewpager);

        tablayout.addTab(tablayout.newTab().setText("Affichage"));
        tablayout.addTab(tablayout.newTab().setText("Recherche"));
        tablayout.addTab(tablayout.newTab().setText("Modification"));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                /*int pos = pager.getCurrentItem();
                pager.removeViewAt(pos);
                pager.addView(fragAdapter.createFragment(pos).onCreateView());
                 */

            }
        });

        FragmentManager fragmanager = getSupportFragmentManager();
        fragAdapter = new FragAdapter(fragmanager,getLifecycle());
        pager.setAdapter(fragAdapter);


    }
}