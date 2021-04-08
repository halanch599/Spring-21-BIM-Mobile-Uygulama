package com.example.bim_1_1.model;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bim_1_1.fragments.CartFragment;
import com.example.bim_1_1.fragments.CategoryFragment;
import com.example.bim_1_1.fragments.HomeFragment;

public class VP2Adapter extends FragmentStateAdapter {
    int tabCount;
    public VP2Adapter(@NonNull FragmentActivity fragmentActivity, int tabCount) {
        super(fragmentActivity);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 0: return  new HomeFragment();
            case 1: return new CategoryFragment();
            case 2: return  new CartFragment();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return tabCount;
    }
}
