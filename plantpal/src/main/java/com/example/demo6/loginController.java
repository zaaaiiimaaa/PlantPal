package com.example.demo6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.example.demo6.myGardenController;
import com.example.demo6.dashboardController;

public class loginController {

    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private Button forpass;
    @FXML
    private TextField myusername;
    @FXML
    private PasswordField mypassword;
    @FXML
    private Label passwordex;
    @FXML
    private Button userpro;
    @FXML
    private TextField plaintextField;
    @FXML
    private RadioButton showPassword;

    String u;
    String p;

   /* @FXML
    void loginBtn(MouseEvent event) throws IOException {
        u = myusername.getText(); // login theke jeita nisi
        p = mypassword.getText();

        String p2= find(u);

        if(p2!= null) {
            if (p2.equals(p)) {
                Stage stage = (Stage) login.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            }
        }
    } */
   @FXML
   void loginBtn(MouseEvent event) throws IOException {
       u = myusername.getText(); // Username input from the login form
       p = mypassword.getText(); // Password input from the login form

       String p2 = find(u);
       dashboardController d;
       d = new dashboardController();
       d.setuser(u);

       myGardenController e;
       e=new myGardenController();
       e.setuser(u);

       sellplantController s;
       s=new sellplantController();
       s.setuser(u);

       PopupController pi;
       pi=new PopupController();
       pi.setuser(u);

     // myGardenController e=fxmlLoader.getController();


       if (p2 != null) {
           if (p2.equals(p)) {
               // Successful login
               System.out.println("Login successful for user: " + u);


               Stage stage = (Stage) login.getScene().getWindow();
               FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dashboard.fxml"));
               Scene scene = new Scene(fxmlLoader.load());
               scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
               stage.setScene(scene);
               stage.centerOnScreen();
               stage.show();
           } else {
               // Password doesn't match
               passwordex.setText("Password Incorrect For User "+u);
               passwordex.setVisible(true);
               System.out.println("Incorrect password for user: " + u);
           }
       } else {
           // User not found
           System.out.println("User not found: " + u);
       }
   }
    private String find(String u)
    {
        try(BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\GitHub\\PlantPal\\plantpal\\src\\AllUsers.txt")))
        {
            String line;
            while((line=reader.readLine())!=null)
            {
                String [] parts=line.split(",");
                if(parts.length>1)
                {
                    String savedUsername=parts[2].trim(); // file theke neowa
                    String pass=parts[4].trim(); // file theke neowa
                    if(u.equals(savedUsername))
                    {
                        return pass;
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    @FXML
    void signupBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) signup.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    void forpassbtn(MouseEvent event) throws IOException{
        Stage stage =(Stage) forpass.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("forpass.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    public void toggleShowPassword(ActionEvent event) {
        if (showPassword.isSelected()) {
            // When the radio button is selected, show the plain text and hide the password field
            plaintextField.setText(mypassword.getText());
            plaintextField.setVisible(true);
            plaintextField.setManaged(true);
            mypassword.setVisible(false);
            mypassword.setManaged(false);
        } else {
            // When the radio button is deselected, show the password field and hide the plain text
            mypassword.setText(plaintextField.getText());
            mypassword.setVisible(true);
            mypassword.setManaged(true);

            plaintextField.setVisible(false);
            plaintextField.setManaged(false);
        }
    }
}
