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

        String description = "Milkweeds (Asclepias spp.) are the required host plants for caterpillars of the monarch butterfly and" +
                " thus play a critical role in the monarch’s life cycle. The loss of milkweed plants in the monarch’s spring and " +
                "summer breeding areas across the United States is believed to be a significant factor contributing to " +
                "the reduced number of monarchs recorded in overwintering sites in California and Mexico. Agricultural " +
                "intensification, development of rural lands, and the use of mowing and herbicides to control roadside " +
                "vegetation have all reduced the abundance of milkweeds in the landscape" +
                "To help offset the loss of monarch breeding habitat, the North American Monarch " +
                "Conservation Plan (published in 2008 by the tri-national Commission for Environmental Cooperation) recommends the " +
                "planting of regionally appropriate native milkweed species. However, a scarcity of milkweed seed in many regions of the " +
                "United States has limited opportunities to include the plants in regional restoration efforts.";

        String care = "Common milkweed might not be the best choice for formal perennial borders because of its tendency to get weedy and spread aggressively. " +
                "It's better suited for naturalized areas like open fields and meadows and butterfly gardens";

        String plantingSchedule = "The best time to put in Milkweed plants is in early spring after the danger of frost has passed, " +
                "while the best time to plant milkweed from seed is in late fall - this allows mother Nature to take care of the cold " +
                "stratification for you";


        milkweed.setDescription(description);
        milkweed.setCare(care);
        milkweed.setPlantingSchedule(plantingSchedule);
        garden.addPlant(milkweed);

        Plant tulips = new Plant("Tulips", 2);
        tulips.setDescription("a fragrant and color flower loves by all");
        garden.addPlant(tulips);

        Plant roses = new Plant("Roses", 3);
        roses.setDescription("A classic gift for a loved one");
        garden.addPlant(roses);

        Plant butterflyBush = new Plant("Butterfly Bush", 4);
        butterflyBush.setDescription("purple and sweet");
        garden.addPlant(butterflyBush);

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