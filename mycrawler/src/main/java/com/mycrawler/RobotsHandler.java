package com.mycrawler;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.Connection;

public class RobotsHandler {
    // Checks if crawling is allowed for the given URL.
    public boolean isAllowed(String urlString) {
        try {
            System.out.println("Fetching robots.txt for URL: " + urlString);

            // Parse the URL to construct the robots.txt URL.
            URL url = new URL(urlString);
            String robotsURL = url.getProtocol() + "://" + url.getHost() + "/robots.txt";

            // Fetch robots.txt content.
            Connection.Response response = Jsoup.connect(robotsURL).ignoreContentType(true).execute();
            String robotsTxt = response.body();

            // Parse robots.txt rules.
            String path = url.getPath();
            List<String> lines = List.of(robotsTxt.split("\n"));
            boolean isDisallowed = false;

            for (String line : lines) {
                line = line.trim();
                if (line.startsWith("Disallow:")) {
                    String disallowedPath = line.substring(9).trim(); // Extract the path after "Disallow:"
                    if (disallowedPath.isEmpty()) {
                        continue; // Empty Disallow means nothing is disallowed.
                    }
                    if (path.startsWith(disallowedPath)) {
                        isDisallowed = true; // Match found for disallowed path.
                    }
                } else if (line.startsWith("Allow:")) {
                    String allowedPath = line.substring(6).trim(); // Extract the path after "Allow:"
                    if (path.startsWith(allowedPath)) {
                        isDisallowed = false; // Override with allow rule.
                    }
                }
            }

            // Return true if not explicitly disallowed.
            return !isDisallowed;

        } catch (IOException e) {
            System.err.println("Error reading robots.txt: " + urlString + " - " + e.getMessage());
            return true; // Default to true if robots.txt is inaccessible.
        }
    }
}

