package com.example.gardenapp.ui.plant;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.gardenapp.R;
import com.example.gardenapp.data.plant.Plant;
import com.example.gardenapp.data.plant.PlantAPIHandler;
import com.example.gardenapp.data.plant.QueryBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.json.JSONObject;

import java.util.HashMap;

public class PlantFragment extends Fragment implements ViewModelStoreOwner {


    private PlantViewModel viewModel;
    private NavController navController;
    private TextView plantTitle;
    private TabLayout tl;
    private TabLayout.Tab plantDescriptionTab;
    private TabLayout.Tab plantDatesTab;
    private TabLayout.Tab plantTipsTab;
    private ViewPager2 plantViewPager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Plant plant = (Plant) getArguments().getParcelable("plant_object"); //getting the plant objects that was passed in
        viewModel = new ViewModelProvider(this).get(PlantViewModel.class);
        viewModel.initPlantState(plant); //gives the plant object to the view model to create live data object
        //setNavController(view); // set nav controller and adding args
        setViews(view);
        updateUI();

        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                plantViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //nothing to do
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //nothing to do
            }
        });

        plantViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getContext(), "changing pages", Toast.LENGTH_SHORT).show();
                tl.selectTab(tl.getTabAt(position));
            }
        });
    }

    private void setViews(View view){
        tl = view.findViewById(R.id.plant_tabs);

        this.plantViewPager = view.findViewById(R.id.plant_view_pager);
        FragmentManager fragmentManager = getChildFragmentManager();
        Lifecycle lifecycle = getLifecycle();
        PlantViewPagerAdapter adapter = new PlantViewPagerAdapter(fragmentManager, lifecycle, this.viewModel);
        this.plantViewPager.setAdapter(adapter);

        plantDescriptionTab = tl.newTab();
        plantDescriptionTab.setText("About");

        plantDatesTab = tl.newTab();
        plantDatesTab.setText("Care");

        plantTipsTab = tl.newTab();
        plantTipsTab.setText("Schedule");

        tl.addTab(plantDescriptionTab);
        tl.addTab(plantDatesTab);
        tl.addTab(plantTipsTab);

        this.plantTitle = view.findViewById(R.id.plant_title);
        this.plantViewPager.setCurrentItem(plantDescriptionTab.getPosition());

        }

    //use view model to update the UI of the plant fragment
    private void updateUI() {
        this.plantTitle.setText(viewModel.getPlantTitle());

    }

    private void setNavController(View view) {

        //getting the nav controller for the
        navController = Navigation.findNavController(view);

        //when navigating to the plant navgraph, we have to specify arguments for the start destination
        Bundle args = new Bundle();
        args.putParcelable("plant", viewModel.getPlantObject());
    }
}