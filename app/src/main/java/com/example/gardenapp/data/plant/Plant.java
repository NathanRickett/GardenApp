package com.example.gardenapp.data.plant;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Plant implements Parcelable {

    String plantName;
    String plantType;
    String description;
    int plantID;

    public Plant() {
        this.plantName = "empty plant name";
        this.plantType = "empty plant type";
        this.plantID = 0;
    }

    public Plant(String plantName, int plantID) {
        this.plantName = plantName;
        this.plantID = plantID;
        this.plantType = "empty plant type";
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public int getPlantID() {
        return plantID;
    }

    public void setPlantID(int plantID) {
        this.plantID = plantID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {

    }
}
