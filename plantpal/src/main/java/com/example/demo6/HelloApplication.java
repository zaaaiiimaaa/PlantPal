package com.example.demo6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class HelloApplication extends Application {

    private Scheduler scheduler;

    @Override
    public void start(Stage stage) throws IOException {
        // Initialize the Quartz scheduler
        initScheduler();

        // Load the GUI
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("PlantPal");
        stage.setResizable(false);
        stage.setScene(scene);

        final double[] x = new double[1];
        final double[] y = new double[1];
        root.setOnMousePressed(event -> {
            x[0] = event.getSceneX();
            y[0] = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x[0]);
            stage.setY(event.getScreenY() - y[0]);
        });

        // Show the GUI
        stage.show();
    }

    private void initScheduler() {
        try {
            scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            // Define the job and tie it to EmailJob class
            JobDetail job = newJob(EmailJob.class)
                    .withIdentity("emailJob", "group1")
                    .build();

            // Trigger to run job now, and then repeat every 40 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("emailTrigger", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(40)
                            .repeatForever())
                    .build();

            // Schedule the job
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        // Called when JavaFX application is stopped
        if (scheduler != null) {
            scheduler.shutdown();
        }
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}