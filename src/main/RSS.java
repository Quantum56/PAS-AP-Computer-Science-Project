package main;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

public class RSS {

	public String getRss(String URL) {
		
		return readRSSFeed(" " + URL + " ");
		// System.out.println(readRSSFeed("https://www.sciencedaily.com/rss/top.xml%22));
	}

	public static String readRSSFeed(String urlAddress) {
		try {
			URL rssUrl = new URL(urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
			String sourceCode = "";
			String line;
			while ((line = in.readLine()) != null) {
				int titleEndIndex = 0;
				int titleStartIndex = 0;
				line = line.replace("<![CDATA[", "    ");
				line = line.replace("]]>", "      |   ");
				while (titleStartIndex >= 0) {
					titleStartIndex = line.indexOf("<title>", titleEndIndex);
					if (titleStartIndex >= 0) {
						titleEndIndex = line.indexOf("</title>", titleStartIndex);
						sourceCode += line.substring(titleStartIndex + "<title>".length(), titleEndIndex) + "\t";
					}
				}
			}
			in.close();
			return sourceCode;
		} catch (MalformedURLException ue) {
			System.out.println("Malformed URL");
		} catch (IOException ioe) {
			System.out.println("Something went wrong reading the contents");
		}
		return null;
	}
}