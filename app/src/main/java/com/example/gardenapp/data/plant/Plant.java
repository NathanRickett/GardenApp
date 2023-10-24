package com.example.gardenapp.data.plant;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.HashMap;

public class Plant implements Parcelable {

    private String plantName;
    private String commonName;
    private String scientificName;
    private String description;

    private String state_province;
    private String county;
    private String water;
    private String temperature;
    private String soil;
    private String fertilizer;
    private String hardinessZone;
    private String sunExposure;
    private String growthHabits;
    private String plantingSchedule;
    private String harvestSchedule;
    private String pruningSchedule;

    private String care;
    private int plantID;
    private int maxTemp;
    private int minTemp;
    private boolean isNative;
    private boolean isIntroduced;
    private boolean isNoxious;
    private boolean isFedThreatened;
    private boolean isStThreatened;
    private boolean isInvasive;



    public Plant() {
        init();
        this.plantName = "empty plant name";
        this.commonName = "empty plant type";
        this.plantID = 0;
    }

    public Plant(String plantName, int plantID) {
        init();
        this.plantName = plantName;
        this.plantID = plantID;
        this.commonName = "empty plant type";
    }

    protected Plant(Parcel in) {
        init();
        plantName = in.readString();
        commonName = in.readString();
        description = in.readString();
        plantID = in.readInt();
    }

    private void init() {
        setCare("care");
        setCommonName("common name");
        setCounty("county");
        setDescription("description");
        setFertilizer("fertilizer");
        setGrowthHabits("growth habits");
        setHardinessZone("hardiness zone");
        setHarvestSchedule("harvest schedule");
        setMaxTemp(99);
        setMinTemp(0);
        setPlantID(0);
        setPlantName("plant name");
        setPlantingSchedule("planting schedule");
        setPruningSchedule("pruning schedule");
        setScientificName("scientific name");
        setSoil("soil");
        setState_province("state province");
        setSunExposure("sun exposure");
        setTemperature("temperature");
        setWater("water");
        this.isFedThreatened = false;
        this.isIntroduced = false;
        this.isInvasive = false;
        this.isNative = false;
        this.isNoxious = false;
        this.isStThreatened = false;
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


    public String getCare() {
        return care;
    }

    public void setCare(String care) {
        this.care = care;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(String fertilizer) {
        this.fertilizer = fertilizer;
    }

    public String getGrowthHabits() {
        return growthHabits;
    }

    public void setGrowthHabits(String growthHabits) {
        this.growthHabits = growthHabits;
    }

    public String getHardinessZone() {
        return hardinessZone;
    }

    public void setHardinessZone(String hardinessZone) {
        this.hardinessZone = hardinessZone;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public String getSunExposure() {
        return sunExposure;
    }

    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public String getHarvestSchedule() {
        return harvestSchedule;
    }

    public void setHarvestSchedule(String harvestSchedule) {
        this.harvestSchedule = harvestSchedule;
    }

    public String getPlantingSchedule() {
        return plantingSchedule;
    }

    public void setPlantingSchedule(String plantingSchedule) {
        this.plantingSchedule = plantingSchedule;
    }

    public String getPruningSchedule() {
        return pruningSchedule;
    }

    public void setPruningSchedule(String pruningSchedule) {
        this.pruningSchedule = pruningSchedule;
    }

    public boolean isFedThreatened() {
        return this.isFedThreatened;
    }

    public boolean isIntroduced() {
        return this.isIntroduced;
    }

    public boolean isInvasive() {
        return this.isInvasive;
    }

    public boolean isNative() {
        return this.isNative;
    }

    public boolean isNoxious() {
        return this.isNoxious;
    }

    public boolean isStThreatened() {
        return this.isStThreatened;
    }

    public static final Creator<Plant> CREATOR = new Creator<Plant>() {
        @Override
        public Plant createFromParcel(Parcel in) {
            return new Plant(in);
        }

        @Override
        public Plant[] newArray(int size) {
            return new Plant[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(plantName);
        dest.writeString(commonName);
        dest.writeString(description);
        dest.writeInt(plantID);
    }
}
