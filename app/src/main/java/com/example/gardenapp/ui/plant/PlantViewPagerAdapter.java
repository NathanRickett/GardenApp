package com.example.gardenapp.ui.plant;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class PlantViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragments;
    private PlantViewModel viewModel; //view model for providing live data of plant object


    public PlantViewPagerAdapter(@NonNull FragmentManager fragmentManager, Lifecycle lifecycle, PlantViewModel viewModel) {
        super(fragmentManager, lifecycle);
        this.viewModel = viewModel;
        init();
    }

    private void init() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new PlantInfoFragment(viewModel));
        fragments.add(new PlantCareFragment(viewModel));
        fragments.add(new PlantScheduleFragment(viewModel));
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //TODO implement stuff here
        return fragments.get(position);

    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }


}
