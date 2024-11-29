package com.mycrawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Saves the crawled data
public class DataStorage {
	public void save(String url, String html) {
		try {
			//Generate Filename with the URL
			String filename = url.replaceAll("[^a-zA-Z0-9]", "_") + ".html";
			File file = new File("data/" + filename);
			file.getParentFile().mkdirs(); //Generate path if not already generated
			
			FileWriter writer = new FileWriter(file);
			writer.write(html); //Write the html in the file
			writer.close();
		} catch (IOException e) {
			System.err.println("Error while saving: " + url + " - " + e.getMessage());
		}
	}
}
