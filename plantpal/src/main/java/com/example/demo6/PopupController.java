package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PopupController {
    private SellPlantDataHandler dataHandler = new SellPlantDataHandler();

    @FXML
    private Button okbtn;
    @FXML
    private TextField plantname;
    @FXML
    private Label plantlabel;
    static String us;

    public void setuser(String user) {
        us = user;
    }

    @FXML
    private void okload() throws IOException {
        String plantName = plantname.getText();

        if (dataHandler.searchPlantData(us, plantName)) {
            Stage stage = (Stage) okbtn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("delete.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);

            PlantDeletionConfirmationController deletionController = fxmlLoader.getController();
            deletionController.loadPlantDetails(plantName);

        } else {
            plantlabel.setText("Plant data was not found");
            plantlabel.setVisible(true);
        }
    }

    @FXML
    private void onOkButtonPressed() {
        // This might be redundant if okload() is handling the logic
        // Consider merging logic or separating concerns more clearly
    }
}
