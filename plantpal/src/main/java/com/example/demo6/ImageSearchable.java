package com.example.demo6;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public interface ImageSearchable {
    void searchImages();

    default void commonImageSearchLogic(String imageFolderPath, String searchCriteria, VBox imageContainer) {
        imageContainer.getChildren().clear();
        imageContainer.setSpacing(30);

        List<ImageView> matchingImages = new ArrayList<>();
        boolean foundMatch = false;

        File folder = new File(imageFolderPath);
        File[] imageFiles = folder.listFiles();

        if (imageFiles != null) {
            for (File imageFile : imageFiles) {
                String imageName = imageFile.getName().toLowerCase();
                if (imageName.contains(searchCriteria.toLowerCase())) {
                    ImageView imageView = new ImageView(imageFile.toURI().toString());
                    imageView.setFitWidth(400);
                    imageView.setPreserveRatio(true);
                    imageContainer.getChildren().add(imageView);
                    foundMatch = true;
                }
            }
        }

        if (!foundMatch) {
            File sorryImageFile = new File(imageFolderPath + "/sorry.png");
            if (sorryImageFile.exists()) {
                ImageView defaultImageView = new ImageView(sorryImageFile.toURI().toString());
                defaultImageView.setFitWidth(400);
                defaultImageView.setPreserveRatio(true);
                imageContainer.getChildren().add(defaultImageView);
            }
        }
    }
}