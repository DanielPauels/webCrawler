package com.mycrawler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

//Fetches HTML content from web pages.
public class HTMLFetcher {
	public String fetch(String urlString) {
		try {
			//Open a connection to the URL
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET"); //Use the GET HTTP method
			connection.setConnectTimeout(10000); //Connection timeout in milliseconds
			connection.setReadTimeout(10000); //Read timeout in milliseconds
			
			//If the HTTP status code is 200 (OK):
			if (connection.getResponseCode() == 200) {
				Scanner scanner = new Scanner(connection.getInputStream());
				StringBuilder html = new StringBuilder();
				
				//Read the HTML content line by line
				while(scanner.hasNextLine()) {
					System.out.println("Scanner has next line. Continuing to append...");
					html.append(scanner.nextLine());
				}
				scanner.close();
				return html.toString();
			}
			else {
				System.err.println("Error fetching page: " + connection.getResponseCode());
			}
		}catch (IOException e) {
			System.err.println("Connection error " + urlString + " - " + e.getMessage());
		}
		return null; //Return null if page could not be fetched
	}
}
