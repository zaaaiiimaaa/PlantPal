package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class fertilizerController {
    @FXML
    private Button logo;
    @FXML
    private Button organic;
    @FXML
    void logoBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
    @FXML
    void npkBtn(MouseEvent event) throws IOException {
        Stage newstage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fert1.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        newstage.setScene(scene);
        newstage.setResizable(false);
        newstage.show();
    }
    @FXML
    void organicBtn(MouseEvent event) throws IOException {
        Stage newstage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fert2.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        newstage.setScene(scene);
        newstage.setResizable(false);
        newstage.show();
    }
    @FXML
    void nitroBtn(MouseEvent event) throws IOException {
        Stage newstage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fert3.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        newstage.setScene(scene);
        newstage.setResizable(false);
        newstage.show();
    }
    @FXML
    void phosphoBtn(MouseEvent event) throws IOException {
        Stage newstage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fert4.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        newstage.setScene(scene);
        newstage.setResizable(false);
        newstage.show();
    }
}
