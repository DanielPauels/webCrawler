package com.mycrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

//Parses HTML pages and extracts links
public class HTMLParser {
	public Set<String> extractLinks(String html, String baseUrl){
		Set<String> links = new HashSet<>(); //Set to store extracted links
		Document doc = Jsoup.parse(html, baseUrl); //Parse the HTML
		
		//Find all <a> tags with href attributes
		Elements anchorTags = doc.select("a[href]");
		for (Element anchor : anchorTags) {
			String link = anchor.absUrl("href"); //Converts relatice URLs to absloute
			links.add(link); //Add the link to the set
		}
		return links; //Return the set of links
	}
}
