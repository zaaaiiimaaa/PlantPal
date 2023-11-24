package com.example.demo6;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmailJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String message = "Hello user, It is time to water your plants.";
        String subject = "Scheduled Email from PlantPal";
        String from = "plantpalcommunity@gmail.com";

        try {
            List<String> emailAddresses = getEmailAddresses();

            for (String to : emailAddresses) {
                Email2.sendEmail(message, subject, to, from);
            }
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }

    private List<String> getEmailAddresses() throws IOException {
        List<String> emailAddresses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/AllUsers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1) {
                    String email = parts[1].trim(); // Assuming email is the second entry
                    emailAddresses.add(email);
                }
            }
        }
        return emailAddresses;
    }
}
