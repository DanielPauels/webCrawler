package com.mycrawler;

// A data structure to store a URL and its associated depth.
public class URLDepthPair {
    private String url; // The URL to crawl.
    private int depth;  // The depth of the URL (how far from the seed URL).

    // Constructor to initialize the URL and its depth.
    public URLDepthPair(String url, int depth) {
        this.url = url;
        this.depth = depth;
    }

    // Getter for the URL.
    public String getUrl() {
        return url;
    }

    // Getter for the depth.
    public int getDepth() {
        return depth;
    }
}
