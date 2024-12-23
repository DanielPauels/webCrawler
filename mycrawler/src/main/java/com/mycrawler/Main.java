package com.mycrawler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the web crawler...");

        // Initialize the crawler with maxDepth = 2 and maxPages = 5
        Crawler crawler = new Crawler(2, 5);

        // Start crawling from a seed URL
        crawler.start("https://www.github.com");
    }
}
