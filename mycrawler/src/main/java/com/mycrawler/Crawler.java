package com.mycrawler;

import java.util.Set;

public class Crawler {
	private URLFrontier urlFrontier; // Manages the queue of URLs to visit.
	private VisitedSet visitedSet; // Tracks already visited URLs.
	private HTMLFetcher htmlFetcher; // Fetches HTML content from web pages.
	private HTMLParser htmlParser; // Parses HTML and extracts links.
	private RobotsHandler robotsHandler; // Checks if crawling is allowed by robots.txt.
	private DataStorage dataStorage; // Saves crawled data.

	private int maxDepth; // Maximum depth of links to follow.
	private int maxPages; // Maximum number of pages to visit.

	// Constructor: Initializes modules and sets limits for the crawl process.
	public Crawler(int maxDepth, int maxPages) {
		this.urlFrontier = new URLFrontier();
		this.visitedSet = new VisitedSet();
		this.htmlFetcher = new HTMLFetcher();
		this.htmlParser = new HTMLParser();
		this.robotsHandler = new RobotsHandler();
		this.dataStorage = new DataStorage();
		this.maxDepth = maxDepth;
		this.maxPages = maxPages;
	}

	// Starts the crawling process with a seed URL.
	public void start(String seedUrl) {
		System.out.println("Starting crawl with seed URL: " + seedUrl);

		// Add the seed URL with depth 0 to the queue.
		urlFrontier.add(seedUrl, 1);
		System.out.println("Added URL to frontier: " + seedUrl);

		// Continue crawling while there are URLs in the queue and the page limit is not
		// reached.
		while (!urlFrontier.isEmpty() && visitedSet.size() < maxPages) {

			URLDepthPair current = urlFrontier.poll(); // Get the next URL from the queue.
			if (current != null) {

				String currentUrl = current.getUrl(); // The current URL.
				int currentDepth = current.getDepth(); // The current depth.

				if (visitedSet.contains(currentUrl)) {
					System.out.println("Skipping already visited URL: " + currentUrl);
					continue;
				}
				if (currentDepth > maxDepth) {
					System.out.println("Skipping URL due to max depth: " + currentUrl);
					continue;
				}

				// Check if the URL is allowed by robots.txt.
				System.out.println("Checking robots.txt for URL: " + currentUrl);
				if (robotsHandler.isAllowed(currentUrl)) {
					System.out.println("Crawling allowed for URL: " + currentUrl);
				} else {
					System.out.println("Crawling disallowed for URL: " + currentUrl);
					continue;
				}

				System.out.println("Fetching HTML for URL: " + currentUrl);
				String html = htmlFetcher.fetch(currentUrl);
				if (html != null) {
					System.out.println("Fetched HTML for URL: " + currentUrl); // If the page was successfully fetched:
					visitedSet.add(currentUrl); // Mark the URL as visited.
					dataStorage.save(currentUrl, html); // Save the page content.
					Set<String> links = htmlParser.extractLinks(html, currentUrl);
					System.out.println("Extracted " + links.size() + " links from URL: " + currentUrl);
					urlFrontier.addAll(links, currentDepth + 1); // Add the links to the queue with updated depth.
				} else {
					System.out.println("Failed to fetch HTML for URL: " + currentUrl);
					continue;
				}
			}

		}
	}
}
