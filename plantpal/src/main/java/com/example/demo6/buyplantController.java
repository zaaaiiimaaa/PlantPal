package com.example.demo6;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class buyplantController {

    @FXML
    private Button logo, logout, searchButton;
    @FXML
    private TextField searchField;
    @FXML
    private ScrollPane scrollPane;

    private List<Plant> plantsForSale = new ArrayList<>();

    @FXML
    void logoBtn(MouseEvent event) throws IOException {
        changeScene("dashboard.fxml");
    }

    @FXML
    void logoutBtn(MouseEvent event) throws IOException {
        changeScene("login.fxml");
    }

    private void changeScene(String fxmlFile) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }

    @FXML
    void searchButtonAction() {
        String query = searchField.getText();
        displayPlants(query);
    }

    @FXML
    public void initialize() {
        loadPlantsFromFile();
        displayPlants("");
    }

    private void loadPlantsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\sellimageData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] plantData = line.split(",");
                if (plantData.length < 5) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }
                Plant plant = new Plant(
                        plantData[0], // Name
                        plantData[1], // Description
                        Double.parseDouble(plantData[2]), // Price
                        plantData[3], // Image Path
                        plantData[4]  // Mobile Number
                );
                plantsForSale.add(plant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayPlants(String query) {
        VBox plantsContainer = new VBox(30);
        plantsContainer.setAlignment(Pos.CENTER);
        for (Plant plant : searchPlants(query)) {
            VBox plantBox = createPlantVBox(plant);
            plantsContainer.getChildren().add(plantBox);
        }
        scrollPane.setContent(plantsContainer);
    }

    private VBox createPlantVBox(Plant plant) {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        Label nameLabel = new Label(plant.getName());
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        nameLabel.setAlignment(Pos.CENTER);

        Label descriptionLabel = new Label(plant.getDescription());
        descriptionLabel.setMaxWidth(Double.MAX_VALUE);
        descriptionLabel.setAlignment(Pos.CENTER);

        Label priceLabel = new Label(String.format("$%.2f", plant.getPrice()));
        priceLabel.setMaxWidth(Double.MAX_VALUE);
        priceLabel.setAlignment(Pos.CENTER);

        Label mobileNumberLabel = new Label(plant.getMobilenumber());
        mobileNumberLabel.setMaxWidth(Double.MAX_VALUE);
        mobileNumberLabel.setAlignment(Pos.CENTER);

        ImageView imageView = new ImageView(new Image("file:" + plant.getImagePath()));
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);
        StackPane imageContainer = new StackPane(imageView);
        imageContainer.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(imageContainer, nameLabel, descriptionLabel, priceLabel, mobileNumberLabel);
        return vbox;
    }

    public List<Plant> searchPlants(String query) {
        List<Plant> searchResults = new ArrayList<>();
        for (Plant plant : plantsForSale) {
            if (plant.getName().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(plant);
            }
        }
        return searchResults;
    }

    class Plant {
        private String name;
        private String description;
        private double price;
        private String imagePath;
        private String mobilenumber;

        public Plant(String name, String description, double price, String imagePath, String mobilenumber) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.imagePath = imagePath;
            this.mobilenumber = mobilenumber;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }

        public String getImagePath() {
            return imagePath;
        }

        public String getMobilenumber() {
            return mobilenumber;
        }
    }
}
