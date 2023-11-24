package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.regex.Pattern;

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
    private Label usernameex;
    @FXML
    private Label emailex;


    @FXML
    void signInBtn(MouseEvent event) throws IOException {
        String Full=FullnameField.getText();
        String email=Emailfield.getText();
        String user=UsernameField.getText();
        String number=NumberField.getText();
        String pass=PasswordField.getText();
        String repeat=RepeatField.getText();
        try {
            boolean hasError = false;

            if (!isValidEmail(email)) {
                emailex.setText("Email should end with gmail.com");
                emailex.setVisible(true);
                hasError = true;
            } else {
                emailex.setVisible(false); // Hide if no error
            }

            if (isUsernameTaken(user)) {
                usernameex.setText("Username is already taken");
                usernameex.setVisible(true);
                hasError = true;
            } else {
                usernameex.setVisible(false); // Hide if no error
            }

            if (hasError) {
                return; // Return only if there's at least one error
            }

            // Proceed with further actions if there are no errors

        } catch (IOException e) {
            e.printStackTrace();
            // Optionally, handle the exception in the UI
        }

        try(BufferedWriter writer=new BufferedWriter(new FileWriter("src/AllUsers.txt",true)))
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

    private boolean isUsernameTaken(String username) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/AllUsers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 2 && parts[2].trim().equals(username)) {
                    return true; // Username found in the file, thus it's taken
                }
            }
        }
        return false; // No matching username found, thus it's not taken
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:gmail\\.com)$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pattern.matcher(email).matches();
    }

}
