package com.example.gardenapp.ui.plant;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gardenapp.data.garden.Garden;
import com.example.gardenapp.data.plant.Plant;

public class PlantViewModel extends ViewModel {
    private MutableLiveData<Plant> plantState;

    public PlantViewModel() {

    }

    public MutableLiveData<Plant> getPlantState() {
        return this.plantState;
    }

    public void initPlantState(Plant plant) {
        plantState = new MutableLiveData(plant);
    }



    public String getPlantDescription() {
        if (this.plantState.getValue().getDescription() == null) {
            return "no description available";
        }
        if (this.plantState.getValue().getDescription().isEmpty()) {
            return "no description available";
        }

        return this.plantState.getValue().getDescription();
    }

    public String getPlantTitle() {
        if (this.plantState.getValue().getPlantName() == null) {
            return "no plant name available";
        }
        if (this.plantState.getValue().getPlantName().isEmpty()) {
            return "no plant name available";
        }

        return this.plantState.getValue().getPlantName();
    }

    // TODO: Implement the ViewModel
}