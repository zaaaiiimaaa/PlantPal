package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class editprofileController {
    @FXML
    private Button logo,about,buyplant,sellplant,fertilizer,disease,mygarden, saveButton;

    @FXML
    private TextField nameField, emailField, phoneField, newPasswordField, usernameLabel;
    @FXML
    private PasswordField oldPasswordField;



    public static String currentUser;

    public void setCurrentUser(String currentUser) {
        editprofileController.currentUser = currentUser;
        System.out.println(currentUser);
        loadUserData();
    }


    @FXML
    void logoBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    void saveBtn(MouseEvent event) throws IOException {
        saveUserData();
        changeScene("dashboard.fxml");
    }



    static String p;
    static String u;
    static int id;


    public void loadUserData() {
        // Load data from AllUsers.txt and populate the fields
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\AllUsers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[2].trim().equals(currentUser)) {
                    // Assuming the format is: name,email,username,phone
//                    nameField.setText(parts[0].trim());
//                    emailField.setText(parts[1].trim());
//                    phoneField.setText(parts[3].trim());

                    p = parts[4].trim();
                    u = parts[2].trim();




                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void saveUserData() throws IOException {
        // Update user data in AllUsers.txt
        List<String> updatedUsers = new ArrayList<>();
        boolean passwordMatch = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\AllUsers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[2].trim().equals(currentUser)) {
                    // Check the password
                    String oldPassword = oldPasswordField.getText();
                    passwordMatch = oldPassword.equals(p);

                    if (passwordMatch) {
                        // Update the line for the currentUser
                        String updatedLine = nameField.getText() + "," + emailField.getText() + "," + usernameLabel.getText() + "," + phoneField.getText() + "," + newPasswordField.getText() + "," + newPasswordField.getText();
                        updatedUsers.add(updatedLine);
                    }
                } else {
                    // Keep the other users' lines unchanged
                    updatedUsers.add(line);
                }
            }
        }

        if (passwordMatch) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\AllUsers.txt"))) {
                for (String userLine : updatedUsers) {
                    writer.write(userLine);
                    writer.newLine();
                }
            }
        } else {
            // Show password mismatch error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Old password does not match.");
            alert.showAndWait();
        }
    }


    @FXML
    void myGardenBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) mygarden.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mygardeneragerpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    void fertilizerBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) fertilizer.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fertilizer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    void diseaseBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) disease.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("diseases.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    void aboutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) about.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aboutus.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }


    @FXML
    void buyplantBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) buyplant.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("buyplant.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    void sellplantBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) sellplant.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sellplant.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }

    private void changeScene(String fxmlFile) throws IOException {
        Stage stage = (Stage) logo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }

}
