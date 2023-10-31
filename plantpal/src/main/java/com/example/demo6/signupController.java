package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class signupController {

    @FXML
    private Label myemail;

    @FXML
    private Label myname;

    @FXML
    private Label mynumber;

    @FXML
    private Label mypass;

    @FXML
    private Label myrepass;

    @FXML
    private Label myusername;

    @FXML
    private Button signIn;

    @FXML
    void signInBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) signIn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signsuccess.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

}
