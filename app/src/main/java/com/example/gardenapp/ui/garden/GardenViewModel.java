package com.example.gardenapp.ui.garden;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gardenapp.data.garden.Garden;
import com.example.gardenapp.data.plant.Plant;

public class GardenViewModel extends ViewModel {
    private MutableLiveData<Garden> gardenState;

    //TODO create a database handler class that can receive an ID and create the plants accordingly
    public GardenViewModel() {
        Garden garden = new Garden("Butterfly Garden");

        Plant milkweed = new Plant("Milkweed", 1);
        milkweed.setDescription("A lanky plant for Monarchs");
        garden.addPlant(milkweed);

        Plant tulips = new Plant("Tulips", 2);
        tulips.setDescription("a fragrant and color flower loves by all");
        garden.addPlant(tulips);

        Plant roses = new Plant("Roses", 3);
        roses.setDescription("A classic gift for a loved one");
        garden.addPlant(roses);

        gardenState = new MutableLiveData(garden);
    }

    public MutableLiveData<Garden> getGardenState() {
        return this.gardenState;
    }

    public void addPlant() {

    }

    public void removePlant(int position) {

        if (gardenState.getValue().getPlants().size() > 0 ) {
            this.gardenState.getValue().getPlants().remove(position);
        }
    }

    public boolean hasPlants() {
        return this.gardenState.getValue().hasPlants();
    }

    //return the title of the garden
    public String getTitle() {
        return this.gardenState.getValue().getTitle();
    }

    //given a position ID of a card, returns that cards plant ID
    public int getPlantID(int position) {
        return this.gardenState.getValue().getPlants().get(position).getPlantID();
    }

    public Plant getPlantObject(int position) {
        if (this.gardenState.getValue().getPlants().size() < position) {
            return new Plant();
        }
        return this.gardenState.getValue().getPlants().get(position);
    }
}