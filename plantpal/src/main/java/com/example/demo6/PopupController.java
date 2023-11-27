package com.example.demo6;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PopupController {
    private SellPlantDataHandler dataHandler = new SellPlantDataHandler();

    @FXML
    private TextField plantname;
    //private String plantName;
    @FXML
    private Label plantlabel;
    static  String us;
    public void setuser(String user)
    {

        us = user;
        // System.out.println(u);
    }
    @FXML
    private void onOkButtonPressed() {

        String plantName = plantname.getText();

        if (dataHandler.searchPlantData(us, plantName)) {
            dataHandler.deletePlantData(us, plantName);
            // Notify user of successful deletion
        } else {
            // Notify user that plant data was not found
            plantlabel.setText("Plant data was not found");
            plantlabel.setVisible(true);
        }
    }
}
