package com.mycrawler;

import java.io.IOException;
import java.net.URL;
import org.jsoup.Jsoup;

//Checks robots.txt to see if crawling is allowed.
public class RobotsHandler {
	public boolean isAllowed(String urlString) {
		try {
			URL url = new URL(urlString);
			String robotsURL = url.getProtocol() + "://" + url.getHost() + "/robots.txt";

			String robotsTxt = Jsoup.connect(robotsURL).ignoreContentType(true).execute().body();
			return !robotsTxt.contains("Disallow: " + url.getPath());
		} catch (IOException e) {
			System.err.println("Error reading robots.txt: " + urlString + " - " + e.getMessage());
			return true; // Default to true if robots.txt is inaccessible.
		}
	}
}
