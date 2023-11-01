package com.example.demo6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class forgotpassContoller {
    @FXML
    private Button ok;
    @FXML
    private TextField usernamefield;
    @FXML
    private TextField otpfield;
    @FXML
    private TextField NewPasswordField;
    @FXML
    private TextField pp;
    @FXML
    private TextField Reuser;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    void okBtn(MouseEvent event) throws IOException {
        Stage stage = (Stage) ok.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("resetpass.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    private  void sendotpbutton() throws MessagingException {
        String username=usernamefield.getText();
        String email=findUserEmail(username);
        if(email!=null)
        {
            String message="Hello "+username+" welcome to PlantPal, Here is your OTP 3456";
            String subject="PlantPal confirmation";
            String to=email;
            String from="plantpalcommunity@gmail.com";

            sendEmail(message,subject,to,from);
        }
        else
        {

        }
    }
    private String findUserEmail(String username)
    {
        try(BufferedReader reader=new BufferedReader(new FileReader("src/AllUsers.txt")))
        {
            String line;
            while((line=reader.readLine())!=null)
            {
                String [] parts=line.split(",");
                if(parts.length>1)
                {
                    String savedUsername=parts[2].trim();
                    String email=parts[1].trim();
                    if(username.equals(savedUsername))
                    {
                        return email;
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
    private static void sendEmail(String message,String subject,String to,String from) throws MessagingException {
        //variable for gmail host
        String host="smtp.gmail.com";

        //get the system properties

        Properties properties=System.getProperties();

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465"); // For SSL
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.port", "465");


        //get the session object
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("plantpalcommunity@gmail.com","npvu uybc ohix qbko");
            }
        });
        session.setDebug(true);
        //compose message
        MimeMessage m=new MimeMessage(session);

        try
        {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);
        }
        catch(Exception e){
            e.printStackTrace();
        }



    }
    @FXML
    private  void matchOTP(ActionEvent event) throws IOException
    {
        String givenOTP=otpfield.getText();
        String OTP="3456";
        String user=usernamefield.getText();
        if(givenOTP.equals(OTP))
        {
            Parent root = FXMLLoader.load(getClass().getResource("resetpass.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {

        }

    }


    @FXML
    private void resetPassword(ActionEvent event)throws IOException {


        String newpass = NewPasswordField.getText();
        //String conpass = pp.getText();
        String un = Reuser.getText();
        File file = new File("src/AllUsers.txt");

        try {
            // Read the existing content of the file
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

            boolean updated = false;

            // Create a temporary list to store the updated lines
            List<String> updatedLines = new ArrayList<>();

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length > 1) {
                    String savedUsername = parts[2].trim();
                    if (un.equals(savedUsername)) {
                        String Full = parts[0].trim();
                        String email = parts[1].trim();
                        String number = parts[3].trim();
                        String uname = un;
                        String userData = Full + "," + email + "," + uname + "," + number + "," + newpass + "," + newpass;
                        updatedLines.add(userData);
                        updated = true;
                    } else {
                        updatedLines.add(line);
                    }
                }
            }

            if (updated) {
                // Write the updated lines back to the file
                Files.write(file.toPath(), updatedLines, StandardCharsets.UTF_8);
                System.out.println("Password updated successfully.");
                Parent  root = FXMLLoader.load(getClass().getResource("login.fxml"));
                stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                System.out.println("Username not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
