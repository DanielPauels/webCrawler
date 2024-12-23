package com.mycrawler;

import java.util.HashSet;
import java.util.Set;

// Tracks visited URLs using a Set.
public class VisitedSet {
    private Set<String> visited; // The set of visited URLs.

    public VisitedSet() {
        this.visited = new HashSet<>(); // Initialize an empty set.
    }

    // Add a URL to the visited set.
    public void add(String url) {
        System.out.println("Marking as visited: " + url);
        visited.add(url);
    }


    // Check if a URL has already been visited.
    public boolean contains(String url) {
        return visited.contains(url);
    }

    // Get the total number of visited pages.
    public int size() {
        return visited.size();
    }
}
