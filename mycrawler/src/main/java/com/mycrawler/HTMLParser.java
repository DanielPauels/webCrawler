package com.mycrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

//Parses HTML pages and extracts links
public class HTMLParser {
	public Set<String> extractLinks(String html, String baseUrl) {
		Set<String> links = new HashSet<>();
		try {
			Document doc = Jsoup.parse(html, baseUrl);
			Elements anchorTags = doc.select("a[href]");
			for (Element link : anchorTags) {
				String absoluteUrl = link.attr("abs:href");
				System.out.println("Extracted link: " + absoluteUrl);
				links.add(absoluteUrl);
			}
		} catch (Exception e) {
			System.err.println("Error parsing HTML for links: " + e.getMessage());
		}
		return links;
	}
}
