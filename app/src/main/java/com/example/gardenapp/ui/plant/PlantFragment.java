package com.example.gardenapp.ui.plant;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gardenapp.R;
import com.example.gardenapp.data.plant.Plant;
import com.example.gardenapp.ui.garden.GardenViewModel;

public class PlantFragment extends Fragment {

    private PlantViewModel mViewModel;
    private TextView plantTitle;
    private TextView plantDescription;
    private int plantID;

    private PlantViewModel viewModel;

    public static PlantFragment newInstance() {
        return new PlantFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant, container, false);
        Plant plant = (Plant) getArguments().getParcelable("plant_object");
        viewModel = new ViewModelProvider(this).get(PlantViewModel.class);
        viewModel.initPlantState(plant); //gives the plant ID to the view model to create a plant object from
        setViews(view);
        updateUI();
        return view;
    }

    private void setViews(View view) {
        plantTitle = view.findViewById(R.id.plant_title);
        plantDescription = view.findViewById(R.id.plant_description);
    }

    //use view model to update the UI of the plant fragment
    private void updateUI() {
        plantTitle.setText(viewModel.getPlantTitle());
        plantDescription.setText(viewModel.getPlantDescription());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PlantViewModel.class);
        // TODO: Use the ViewModel
    }

}