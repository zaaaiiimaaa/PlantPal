package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ImageSearchController implements ImageSearchable{
    @FXML
    private TextField searchField;

    @FXML
    private VBox imageContainer;

    // Specify the path to your image folder
    @Override

    public void searchImages() {
        final String imageFolderPath = "C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\Diseaseimage";
        String searchCriteria = searchField.getText().toLowerCase();  // Convert to lowercase for case-insensitive search

        // Clear previous search results
        imageContainer.getChildren().clear();
        imageContainer.setSpacing(30);

        // List to store matching images
        List<Image> matchingImages = new ArrayList<>();

        File folder = new File(imageFolderPath);
        File[] imageFiles = folder.listFiles();
        boolean foundMatch=false;
        if (imageFiles != null) {
            for (File imageFile : imageFiles) {
                String imageName = imageFile.getName().toLowerCase();  // Convert to lowercase for case-insensitive search
                if (imageName.contains(searchCriteria)) {
                    // Create an ImageView to display the image
                    ImageView imageView = new ImageView(new Image(imageFile.toURI().toString()));
                    imageView.setFitWidth(400);  // Set the width to your desired size
                    imageView.setPreserveRatio(true);

                    // Add the ImageView to the container
                    imageContainer.getChildren().add(imageView);
                    foundMatch=true;
                }
            }
        }
        if (!foundMatch) {
            File sorryImageFile = new File(imageFolderPath + "/sorry.png");
            if (sorryImageFile.exists()) {
                ImageView defaultImageView = new ImageView(new Image(sorryImageFile.toURI().toString()));
                defaultImageView.setFitWidth(400); // Set the width to match other images
                defaultImageView.setPreserveRatio(true);
                imageContainer.getChildren().add(defaultImageView);
            } else {
                System.out.println("Default image 'sorry.png' not found.");
            }
        }
    }
    public void symimage()
    {
        final String imageFolderPath = "C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\Symptomimage";
        String searchCriteria = searchField.getText().toLowerCase();  // Convert to lowercase for case-insensitive search

        // Clear previous search results
        imageContainer.getChildren().clear();
        imageContainer.setSpacing(30);

        // List to store matching images
        List<Image> matchingImages = new ArrayList<>();

        File folder = new File(imageFolderPath);
        File[] imageFiles = folder.listFiles();
        boolean foundMatc=false;
        if (imageFiles != null) {
            for (File imageFile : imageFiles) {
                String imageName = imageFile.getName().toLowerCase();  // Convert to lowercase for case-insensitive search
                if (imageName.contains(searchCriteria)) {
                    // Create an ImageView to display the image
                    ImageView imageView = new ImageView(new Image(imageFile.toURI().toString()));
                    imageView.setFitWidth(400);  // Set the width to your desired size
                    imageView.setPreserveRatio(true);

                    // Add the ImageView to the container
                    imageContainer.getChildren().add(imageView);
                    foundMatc=true;

                }
            }
        }
        if (!foundMatc) {
            File sorryImageFile = new File(imageFolderPath + "/sorry.png");
            if (sorryImageFile.exists()) {
                ImageView defaultImageView = new ImageView(new Image(sorryImageFile.toURI().toString()));
                defaultImageView.setFitWidth(400); // Set the width to match other images
                defaultImageView.setPreserveRatio(true);
                imageContainer.getChildren().add(defaultImageView);
            } else {
                System.out.println("Default image 'sorry.png' not found.");
            }
        }
    }
    @FXML
    private Button logo;
    @FXML
    private Button myGarden;
    @FXML
    void logoBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    void myGardenBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) myGarden.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mygardeneragerpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    private Button buyplant;
    @FXML
    void buyplantBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) buyplant.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("buyplant.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    private Button sellplant;
    @FXML
    void sellplantBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) sellplant.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sellplant.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    private Button logout;
    @FXML
    void logoutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    private Button fertilizer;
    @FXML
    void fertilizerBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) fertilizer.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fertilizer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }
    @FXML
    private Button about;
    @FXML
    void aboutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) about.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aboutus.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }

}
