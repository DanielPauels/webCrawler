package com.mycrawler;

import java.util.Set;

public class Crawler {
	private URLFrontier urlFrontier;
	private VisitedSet visitedSet;
	private HTMLFetcher htmlFetcher;
	private HTMLParser htmlParser;
	private RobotsHandler robotsHandler;
	private DataStorage dataStorage;

	private int maxDepth;
	private int maxPages;

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
	
	
	
}

