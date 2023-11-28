package com.example.demo6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URI;
import java.awt.Desktop;
import java.net.URISyntaxException;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class dashboardController {

    @FXML
    private Label email;
    @FXML
    private Label username;
    @FXML
    private Label name;
    @FXML
    private Label phone;

    @FXML
    private Button myGarden;

    @FXML
    private Button userpro;
    @FXML
    private Button about;
    @FXML
    private Button buyplant;
    @FXML
    private Button sellplant;
    @FXML
    private Button logout;
    @FXML
    private Button fertilizer;
    @FXML
    private Button disease,privacy;
    @FXML
    void initialize() {
        username.setText("Default User"); // Set the default username here
    }
    public dashboardController(String u) {
        this.user1 = u; // Set the user when initializing the controller
    }


    static String user1;
    @FXML
    void myGardenBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) myGarden.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mygardeneragerpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
    }

    @FXML
    void userproBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) userpro.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("myaccount.fxml"));

        // Load the appropriate controller type (myAccountController)
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        System.out.println(user1);
        myAccountController controller = fxmlLoader.getController(); // Cast to the correct type
        if (user1 != null) {
            findUserEmail(user1);

            controller.email.setText(email1);
            controller.name.setText(name1);
            controller.phone.setText(phonenumber);
            controller.username.setText(user1);
            System.out.println(name1);
            System.out.println(email1);
            System.out.println(phonenumber);
        }
    }
    String name1, email1, phonenumber;
    private void findUserEmail(String user)
    {
        System.out.println(user);
        try(BufferedReader reader=new BufferedReader(new FileReader("src/AllUsers.txt")))
        {
            String line;
            while((line=reader.readLine())!=null)
            {
                String [] parts=line.split(",");
                if(parts.length>1)
                {
                    String savedUsername=parts[2].trim();
                    System.out.println(parts[2].trim());
                    if(user.equals(savedUsername))
                    {
                            name1= parts[0].trim();
                            email1= parts[1].trim();
                            phonenumber=parts[3].trim();
                        System.out.println(name1);
                        System.out.println(email1);
                        System.out.println(phonenumber);

                    }
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void setuser(String user)
    {
        username.setText(user);
        user1 = user;
        // System.out.println(u);
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
    @FXML
    void logoutBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) logout.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
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

   public dashboardController()
    {
        username = new Label();
    }
    @FXML
    void privacyBtn(MouseEvent event) throws IOException {
        Stage newstage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("privacypolicy.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        newstage.setScene(scene);
        newstage.setResizable(false);
        newstage.show();
    }
    @FXML
    private void openFeedBackForm(ActionEvent event) {
        String feedbackFormUrl = "https://forms.gle/UENU95HkQmXxVFpZ6";

        try {
            Desktop.getDesktop().browse(new URI(feedbackFormUrl));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void openfacebook(ActionEvent event) {
        String feedbackFormUrl = "https://www.facebook.com/profile.php?id=61554009960574";

        try {
            Desktop.getDesktop().browse(new URI(feedbackFormUrl));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void openinsta(ActionEvent event) {
        String feedbackFormUrl = "https://instagram.com/plantpalcommunity?igshid=NzZlODBkYWE4Ng==";

        try {
            Desktop.getDesktop().browse(new URI(feedbackFormUrl));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}