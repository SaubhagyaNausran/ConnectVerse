package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull Explore fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new BusinessFragment();
            case 2:
                return new MerchantFragment();
            default:
                return new PersonalFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
