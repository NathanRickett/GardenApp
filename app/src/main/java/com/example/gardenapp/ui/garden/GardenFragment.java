package com.example.gardenapp.ui.garden;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.service.credentials.Action;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gardenapp.R;
import com.example.gardenapp.RecyclerViewInterface;


public class GardenFragment extends Fragment implements RecyclerViewInterface {
    RecyclerView plant_recycler_view;
    GardenAdapter adapter;
    GardenViewModel viewModel;
    TextView gardenTitle;

    NavController navController;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_garden, container, false);
        setViews(view);
        viewModel = new ViewModelProvider(this).get(GardenViewModel.class);
        plant_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new GardenAdapter(getContext(), viewModel.getGardenState().getValue().getPlants(), this);
        plant_recycler_view.setAdapter(adapter);

        //observe the garden object for changes to the garden
        viewModel.getGardenState().observe(getViewLifecycleOwner(), garden -> {
            updateUI();
        });


        return view;
    }


    //finds the views that were inflated in this fragment and sets their values
    private void setViews(View gardenFragmentView) {
        gardenTitle = gardenFragmentView.findViewById(R.id.garden_title); // initialize the
        plant_recycler_view = gardenFragmentView.findViewById(R.id.plant_recycler_view);
    }

    //sets the initial values of all of the UI
    private void updateUI() {
        gardenTitle.setText(viewModel.getTitle());
    }

    @Override
    //a click listener for cards listed in the recycler view
    public void onItemClick(int position) {
        //navigate to the plant detail fragment
        //TODO learn how to pass arguments using navigation
        Bundle bundle = new Bundle();
        bundle.putParcelable("plant_object", viewModel.getPlantObject(position));
        NavController nc = Navigation.findNavController(getView());
        nc.navigate(R.id.action_gardensFragment_to_plantFragment, bundle);
    }

    @Override
    // a long click listener for cards listed in the recycler view
    //this will eventually just pull up a menu instead of deleting
    public void onItemLongClick(int position) {
        //remove the item from the data set
        viewModel.removePlant(position);

        //notify the adapter which object was removed (via int position)
        adapter.notifyItemRemoved(position);
    }
}