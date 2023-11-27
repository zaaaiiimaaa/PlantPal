package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class editprofileController {
    @FXML
    private Button logo,about,buyplant,sellplant,fertilizer,disease,mygarden;
    @FXML
    void logoBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    @FXML
    void myGardenBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) mygarden.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mygardeneragerpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    @FXML
    void fertilizerBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) fertilizer.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fertilizer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    @FXML
    void diseaseBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) disease.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("diseases.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    @FXML
    void aboutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) about.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aboutus.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }


    @FXML
    void buyplantBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) buyplant.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("buyplant.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    @FXML
    void sellplantBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) sellplant.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sellplant.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

}
