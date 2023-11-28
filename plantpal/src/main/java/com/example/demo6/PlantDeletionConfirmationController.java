package com.example.demo6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlantDeletionConfirmationController{


    @FXML
    private Label plantNameLabel;
    @FXML
    private Label plantDetailLabel;
    @FXML
    private ImageView plantImageView;
    @FXML
    private Button confirmButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label done;

    static String u;
    static String plant;

    private SellPlantDataHandler dataHandler = new SellPlantDataHandler();

    public void loadPlantDetails(String plantName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\sellimageData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5 && parts[1].trim().equals(plantName)) {
                    plantNameLabel.setText("Plant Name: " + parts[1].trim());
                    plantDetailLabel.setText("Details: " + parts[2].trim() + ", Price: " + parts[3].trim());

                    u = parts[0].trim();
                    plant= parts[1].trim();

                    Image image = new Image("file:" + parts[4].trim());
                    plantImageView.setImage(image);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            plantDetailLabel.setText("Failed to load plant details.");
        }
    }

    @FXML
    private void handleConfirm(MouseEvent e) throws IOException {

//        System.out.println(u);
//        System.out.println(plant);
        if(dataHandler.searchPlantData(u, plant))
        {
            dataHandler.deletePlantData(u, plant);
            //System.out.println("Done");
            done.setText("Deleted Succesfully!");
            done.setVisible(true);


        }
        else
        {

        }


    }

    @FXML
    private void handleCancel(MouseEvent e) throws IOException {



    }
}
