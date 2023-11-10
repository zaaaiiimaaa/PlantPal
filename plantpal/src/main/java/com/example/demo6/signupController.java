package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
    private TextField FullnameField;
    @FXML
    private TextField Emailfield;
    @FXML
    private TextField UsernameField;
    @FXML
    private TextField NumberField;
    @FXML
    private TextField PasswordField;
    @FXML
    private TextField RepeatField;


    @FXML
    void signInBtn(MouseEvent event) throws IOException {
        String Full=FullnameField.getText();
        String email=Emailfield.getText();
        String user=UsernameField.getText();
        String number=NumberField.getText();
        String pass=PasswordField.getText();
        String repeat=RepeatField.getText();

        try(BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\ASUS\\Documents\\GitHub\\PlantPal\\plantpal\\src\\AllUsers.txt",true)))
        {
            String userdata=Full + "," + email +","+ user +","+number+","+pass+","+repeat;
            writer.write(userdata);
            writer.newLine();
            writer.flush();
            String userGardenDirectoryPath="src/User_Garden";
            String userDirectoryPath = userGardenDirectoryPath + File.separator + user;  // Construct the user's directory path

            File userDirectory = new File(userDirectoryPath);
            if (!userDirectory.exists()) {
                if (userDirectory.mkdir()) {
                    System.out.println("User directory created for: " + user);
                } else {
                    System.err.println("Failed to create user directory for: " + user);
                }
            } else {
                System.out.println("User directory already exists for: " + user);
            }

            Stage stage = (Stage) signIn.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signsuccess.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
