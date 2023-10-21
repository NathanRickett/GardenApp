package com.example.gardenapp.data.gardener;

import com.example.gardenapp.data.garden.Garden;

import java.util.ArrayList;

public class Gardener {
    private ArrayList<Garden> gardens;
    private String name;
    private String zone;

    public Gardener() {
        this.gardens = new ArrayList<Garden>();
    }

    public Gardener(String name) {
        this.gardens = new ArrayList<Garden>();
        this.name = name;
    }

    public void setGardens(ArrayList<Garden> gardens) {
        this.gardens = gardens;
    }

    public ArrayList<Garden> getGardens() {
        return this.gardens;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }

    public void addGarden(Garden garden) {
        this.gardens.add(garden);
    }

    public void removeGarden(Garden garden) {
        this.gardens.remove(garden);
    }
}

