package com.example.demo6;

public abstract class PlantDataHandler {

    // Method to search data; to be implemented in subclass
    public abstract boolean searchPlantData(String username, String plantName);

    // Method to delete data; to be implemented in subclass
    public abstract void deletePlantData(String username, String plantName);

    // Common utility methods can also be added here, if needed
}
