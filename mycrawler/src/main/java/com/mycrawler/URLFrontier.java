package com.mycrawler;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Manages a queue of URLs to be crawled.
public class URLFrontier {
	private Queue<URLDepthPair> queue; // The queue of URLs.

	public URLFrontier() {
		this.queue = new LinkedList<>(); // Initialize an empty queue.
	}

	// Add a URL with its crawl depth to the queue.
	public void add(String url, int depth) {
	    System.out.println("Adding to frontier: " + url + " at depth: " + depth);
	    queue.add(new URLDepthPair(url, depth));
	}

	// Add multiple URLs with the same depth to the queue.
	public void addAll(Set<String> urls, int depth) {
		for (String url : urls) {
			add(url, depth);
			System.out.println("URL: " + url + " with the depth of " + depth + " has beed added to the queue.");
		}
	}

	// Retrieve the next URL from the queue.
	public URLDepthPair poll() {
	    URLDepthPair pair = queue.poll();
	    System.out.println("Polling from frontier: " + (pair != null ? pair.getUrl() : "null"));
	    return pair;
	}

	// Check if the queue is empty.
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}