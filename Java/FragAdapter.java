/*
Fragment Adapter role is to create fragments switch the postition of the tabs.


*/


package com.example.project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class FragAdapter extends FragmentStateAdapter {

    public FragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);



    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0 :
                return new fragment1();
            case 1 :
                return  new fragment2();

        }
        return new fragment3();

        }

    public void reCreateFragment(){



    }

    @Override
    public int getItemCount() {
        return 3;
    }
}


