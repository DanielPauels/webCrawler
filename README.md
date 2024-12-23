Java Web Crawler
Overview
This project is a basic web crawler implemented in Java. It crawls web pages starting from a seed URL, fetches their content, extracts hyperlinks, and saves the HTML files locally. The purpose of this crawler is to understand search algorithms, network programming, and file handling.

Features
Fetches HTML content from web pages.
Extracts links from HTML and crawls them up to a configurable depth.
Respects a maximum number of pages to crawl.
Saves HTML files locally to C:\Users\XXX.
Uses a queue-based frontier to manage URLs to be crawled.
Avoids revisiting already crawled pages.
Project Structure
The project has the following folder and class structure:

bash
webCrawler/
├── src/main/java/com/mycrawler/
│   ├── Crawler.java          # Main class managing the crawling process
│   ├── URLFrontier.java      # Manages the queue of URLs to visit
│   ├── VisitedSet.java       # Tracks already visited URLs
│   ├── HTMLFetcher.java      # Fetches HTML content from web pages
│   ├── HTMLParser.java       # Parses HTML content and extracts links
│   ├── DataStorage.java      # Handles saving crawled HTML to disk
│   └── URLDepthPair.java     # Stores URL and depth information
└── pom.xml                   # Maven configuration file
Setup Instructions
Follow these steps to run the project on your local machine.

Prerequisites
Java Development Kit (JDK) 17 or later
Eclipse IDE or IntelliJ IDEA (or any Java IDE)
Maven (for dependency management)
Step-by-Step Setup
Clone the Repository

bash
git clone <repository-url>
cd webCrawler
Import Project into IDE

Open your IDE (e.g., Eclipse or IntelliJ IDEA).
Import the project as a Maven project.
Configure Storage Path (Optional)

By default, crawled HTML pages will be saved to C:\Users\XXX.
To change this, edit the DataStorage class and update the storagePath variable.
Run the Crawler

Open Main.java and set your desired seed URL, maxDepth, and maxPages:
java
public static void main(String[] args) {
    Crawler crawler = new Crawler(2, 10); // Crawl depth of 2, maximum 10 pages
    crawler.start("https://www.google.de"); // Replace with your seed URL
}
Run the program. The crawler will start fetching and saving pages.
How It Works
The program starts crawling from a seed URL.
HTMLFetcher downloads the web page content.
HTMLParser extracts hyperlinks from the downloaded HTML.
Links are added to the URLFrontier, which ensures a breadth-first crawling process.
Crawled URLs are tracked in the VisitedSet to avoid duplication.
DataStorage saves the HTML content to your local machine.
Dependencies
The project uses the following libraries:

Jsoup: For parsing HTML and extracting links.
These dependencies are managed by Maven. The relevant configuration is already in the pom.xml file:

xml
Code kopieren
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.15.4</version>
</dependency>
Example Usage
Configuration:
In Main.java, you can configure:

Seed URL: The starting point for the crawl.
Max Depth: The maximum depth of links to follow.
Max Pages: The maximum number of pages to crawl.
Example Output:
The console will display logs for each step:
csharp
Code kopieren
Starting crawl with seed URL: https://www.google.de
Fetching content for: https://www.github.com
Saved HTML content to: C:\Users\XXX\www_github_com.html
HTML files are stored in the specified directory.

Limitations
Dynamic Content: The crawler cannot execute JavaScript; it only fetches static HTML.
Timeouts: Slow websites or network issues may cause delays.
Future Improvements
Implement RobotsHandler to respect crawling restrictions.
Handle dynamic web pages using tools like Selenium or Puppeteer.
Add multi-threading to speed up crawling.
Improve error handling for robust performance.
Contributing
Feel free to fork the repository and submit pull requests for improvements or bug fixes.

License
This project is licensed under the MIT License.
