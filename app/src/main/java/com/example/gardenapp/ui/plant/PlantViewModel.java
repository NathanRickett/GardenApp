package com.example.gardenapp.ui.plant;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gardenapp.data.garden.Garden;
import com.example.gardenapp.data.plant.Plant;

public class PlantViewModel extends ViewModel {
    private MutableLiveData<Plant> plantState;

    public PlantViewModel() {
        Log.d("debugging", "calling plant view model constructor");
        plantState = new MutableLiveData(new Plant("test", 69));
    }

    public MutableLiveData<Plant> getPlantState() {
        return this.plantState;
    }

    public void initPlantState(Plant plant) {
        this.plantState = new MutableLiveData(plant);
    }



    public String getPlantDescription() {
        if (this.plantState == null) {
            return "null";
        }

        if (this.plantState.getValue().getDescription() == null) {
            return "no description available";
        }
        if (this.plantState.getValue().getDescription().isEmpty()) {
            return "no description available";
        }

        return this.plantState.getValue().getDescription();
    }

    public String getPlantTitle() {
        if (this.plantState == null) {
            return "null";
        }

        if (this.plantState.getValue().getPlantName() == null) {
            return "no plant name available";
        }
        if (this.plantState.getValue().getPlantName().isEmpty()) {
            return "no plant name available";
        }

        return this.plantState.getValue().getPlantName();
    }

    public Plant getPlantObject() {
        return this.plantState.getValue();
    }

    public String getPlantCare() {
        if (getPlantObject() != null) {
            if (getPlantObject().getCare() != null) {
                return this.getPlantObject().getCare();
            }
            else {
                return "null plant care";
            }
        }
        return "null plant";
    }

    // TODO: Implement the ViewModel
}