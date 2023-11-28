package com.example.demo6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class myGardenController {
    @FXML
    private Button logo;
    @FXML
    private Button mypro;
    @FXML
    private Button logout;
    @FXML
    private Button sellplant;
    @FXML
    private Button buyplant;
    @FXML
    private Button fertilizer;
    @FXML
    private Button about;
    @FXML
    private Button disease;
    @FXML
    private ImageView profilePictureImageView;
     static String username;

    @FXML
    void logoBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logo.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    void logoutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
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
    @FXML
    void buyplantBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) buyplant.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("buyplant.fxml"));
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
    void aboutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) about.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aboutus.fxml"));
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

    public void openFileChooser(ActionEvent event) throws IOException {


        System.out.println(username);

        // Create a new FileChooser instance
        FileChooser fileChooser = new FileChooser();

        // Set the title for the file chooser dialog
        fileChooser.setTitle("Select Image File");

        // Define file filters to restrict file types (e.g., allow only image files)
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp")
        );

        // Show the file chooser dialog and wait for the user to select a file
        File selectedFile = fileChooser.showOpenDialog(getPrimaryStage());

        if (selectedFile != null) {
            // Generate a unique identifier for the image (e.g., a random string or UUID)
            String uniqueIdentifier = UUID.randomUUID().toString();

            // Create a unique filename for the image based on the username and the unique identifier
            String imageFileName = username + "_image_" + uniqueIdentifier + getFileExtension(selectedFile.getName());

            // Define the directory path where the images are stored
            String imageDirectoryPath = "C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\User_Garden\\";

            // Combine the directory path and filename to get the full path of the destination file
            String destinationPath = imageDirectoryPath + imageFileName;

            try {
                // Copy the selected file to the destination file (save the uploaded image)
                Files.copy(selectedFile.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Store the association between the user and the image filename in your database

                // Update the profilePictureImageView to display the newly uploaded image
                profilePictureImageView.setImage(new Image(new File(destinationPath).toURI().toString()));

            } catch (IOException e) {
                e.printStackTrace();
                // Handle any errors that occur during file copying or database updates
            }
        }
    }

    private Stage getPrimaryStage() {
        return (Stage) profilePictureImageView.getScene().getWindow();
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex);
        }
        return "";
    }
    public void setuser(String user)
    {

        username = user;
        // System.out.println(u);
    }
    @FXML
    private HBox imageContainer;
    @FXML
    private ScrollPane myScrollPane;
    private final String imageFolderPath = "C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\User_Garden\\";
    public void searchImages() {
        //String searchCriteria = searchField.getText().toLowerCase();  // Convert to lowercase for case-insensitive search
        String searchCriteria=username.toLowerCase();
        // Clear previous search results
        imageContainer.getChildren().clear();

        // List to store matching images
        List<Image> matchingImages = new ArrayList<>();

        File folder = new File(imageFolderPath);
        File[] imageFiles = folder.listFiles();

        if (imageFiles != null) {
            for (File imageFile : imageFiles) {
                String imageName = imageFile.getName().toLowerCase();  // Convert to lowercase for case-insensitive search
                if (imageName.contains(searchCriteria)) {
                    // Create an ImageView to display the image
                    ImageView imageView = new ImageView(new Image(imageFile.toURI().toString()));
                    imageView.setFitWidth(500);
                    imageView.setFitHeight(400);// Set the width to your desired size
                    imageView.setPreserveRatio(false);
                    imageView.setSmooth(true);

                    // Add the ImageView to the container
                    imageContainer.getChildren().add(imageView);

                    myScrollPane.setHvalue(0);
                    myScrollPane.setVvalue(0);
                    imageContainer.requestLayout();

                }
            }
        }
    }
}
