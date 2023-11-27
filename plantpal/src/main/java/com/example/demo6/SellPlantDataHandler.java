package com.example.demo6;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SellPlantDataHandler extends PlantDataHandler {

    private static final String DATA_FILE = "src/sellimageData.txt";

    @Override
    public boolean searchPlantData(String username, String plantName) {
        // Implement logic to search for plant data
        // Return true if found, false otherwise
        List<String> data = readDataFromFile();
        for (String line : data) {
            String[] parts = line.split(" , ");
            if (parts.length > 1 && parts[0].equals(username) && parts[1].equals(plantName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deletePlantData(String username, String plantName) {
        // Implement logic to delete specific plant data
        List<String> data = readDataFromFile();
        List<String> updatedData = new ArrayList<>();

        for (String line : data) {
            String[] parts = line.split(" , ");
            if (!(parts.length > 1 && parts[0].equals(username) && parts[1].equals(plantName))) {
                updatedData.add(line);
            }
        }

        writeDataToFile(updatedData);

    }

    private List<String> readDataFromFile() {
        // Utility method to read data from file
        // Return data as a list of strings
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private void writeDataToFile(List<String> data) {
        // Utility method to write data back to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
