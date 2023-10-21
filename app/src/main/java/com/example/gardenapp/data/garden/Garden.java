package com.example.gardenapp.data.garden;

import com.example.gardenapp.data.gardener.Gardener;
import com.example.gardenapp.data.plant.Plant;

import java.util.ArrayList;

public class Garden {
    private String title;
    private String zone;
    private ArrayList<Plant> plants;

    private Gardener owner;
    public Garden() {
        this.plants = new ArrayList<Plant>();
    }

    public Garden(String title) {
        this.title = title;
        this.plants = new ArrayList<Plant>();
        this.owner = new Gardener("unknown gardener");
    }

    public Garden(String title, Gardener owner) {
        this.title = title;
        this.owner = owner;
        this.plants = new ArrayList<Plant>();
    }

    public Garden(String title, ArrayList<Plant> plants) {
        this.title = title;
        this.plants = plants;
        this.owner = new Gardener("unknown gardener");
    }

    public Garden(String title, ArrayList<Plant> plants, Gardener owner) {
        this.title = title;
        this.plants = plants;
        this.owner = owner;
    }


    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    public void removePlant(Plant plant) {
        if (this.plants.contains(plants)) {
            this.plants.remove(plant);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Gardener getOwner() {
       return this.owner;
    }

    public void setOwner(Gardener owner) {
        this.owner = owner;
    }

    public boolean hasPlants() {
        if (this.plants != null) {
            if (this.plants.size() > 0) {
                return true;
            }
        }
        return false;
    }
}
