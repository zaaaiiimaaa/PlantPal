package com.example.demo6;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.mail.MessagingException;

public class EmailJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Here you would retrieve any job data map parameters or context you've set
        // For simplicity, we're using hardcoded email details
        String message = "Hello user, this is your scheduled message.";
        String subject = "Scheduled Email from PlantPal";
        String to = "pialeemoni@gmail.com"; // This should be replaced with the recipient's email
        String from = "plantpalcommunity@gmail.com";

        try {
            Email2.sendEmail(message, subject, to, from);
        } catch (MessagingException e) {
            throw new JobExecutionException(e);
        }
    }
}

