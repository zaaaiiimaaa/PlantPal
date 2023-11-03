package com.example.demo6;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class ImageSearchController {
    @FXML
    private TextField searchField;

    @FXML
    private VBox imageContainer;
    @FXML
    private Button logoBtn;

    // Specify the path to your image folder
    private final String imageFolderPath = "C:\\Users\\ASUS\\Documents\\GitHub\\PlantPal\\plantpal\\src\\Dimage";

    public void searchImages() {
        String searchCriteria = searchField.getText().toLowerCase();  // Convert to lowercase for case-insensitive search

        // Clear previous search results
        imageContainer.getChildren().clear();
        imageContainer.setSpacing(30);

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
                    imageView.setFitWidth(400);  // Set the width to your desired size
                    imageView.setPreserveRatio(true);

                    // Add the ImageView to the container
                    imageContainer.getChildren().add(imageView);
                }
            }
        }
    }

    public void logoBtn(MouseEvent mouseEvent) {
    }
}
