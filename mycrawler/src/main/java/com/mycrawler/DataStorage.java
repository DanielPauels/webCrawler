package com.mycrawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Saves HTML data to a specified folder.
public class DataStorage {
    // Define the path where HTML files will be saved.
    private final String storagePath = "C:\\Users\\HTML_Pages";

    // Method to save HTML content to a file.
    public void save(String url, String html) {
        try {
            // Generate a filename from the URL by replacing special characters.
            String filename = url.replaceAll("[^a-zA-Z0-9]", "_") + ".html";

            // Create the full path for the file.
            File file = new File(storagePath + "\\" + filename);

            // Ensure the directory exists. If not, create it.
            file.getParentFile().mkdirs();

            // Write the HTML content to the file.
            FileWriter writer = new FileWriter(file);
            writer.write(html);
            writer.close();

            System.out.println("Saved file to: " + file.getAbsolutePath()); // Log the file path for reference.
        } catch (IOException e) {
            // Handle any errors during file creation or writing.
            System.err.println("Error saving file for URL: " + url + " - " + e.getMessage());
        }
    }
}
