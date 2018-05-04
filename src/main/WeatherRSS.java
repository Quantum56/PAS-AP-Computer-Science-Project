package main;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;

public class WeatherRSS {

	public static void main(String[] args) {

		// System.out.print(readRSSFeed("http://www.rssweather.com/zipcode/02871/rss.php"));
		// System.out.println(readRSSFeed("https://www.sciencedaily.com/rss/top.xml%22));
	}

	public String readRSSFeed(String urlAddress) {
		try {
			URL rssUrl = new URL(urlAddress);
			BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
			String sourceCode = "";
			String line;
			TimerObj a = new TimerObj();
			while ((line = in.readLine()) != null) {
				int titleEndIndex = 0;
				int titleStartIndex = 0;
				line = line.replace("<![CDATA[", "");
				line = line.replace("]]>", "");
				line = line.replace("Today", "");
				line = line.replace("Tonight", "");
				if (a.getDayOfWeek() == 1) { // sunday
					line = line.replace("Friday", "");
					line = line.replace("Thursday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Wednesday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Monday", "");
					line = line.replace("Tuesday", "");
					
				} else

				if (a.getDayOfWeek() == 2) { // monday
					line = line.replace("Friday", "");
					line = line.replace("Thursday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Sunday", "");
					line = line.replace("Wednesday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Tuesday", "");
				} else

				if (a.getDayOfWeek() == 3) { // tuesday
					line = line.replace("Friday", "");
					line = line.replace("Thursday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Sunday", "");
					line = line.replace("Wednesday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Monday", "");
				} else

				if (a.getDayOfWeek() == 4) { // wednesday
					line = line.replace("Friday", "");
					line = line.replace("Thursday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Sunday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Monday", "");
					line = line.replace("Tuesday", "");
				} else

				if (a.getDayOfWeek() == 5) { // thursday 
					line = line.replace("Friday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Sunday", "");
					line = line.replace("Wednesday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Monday", "");
					line = line.replace("Tuesday", "");
				} else

				if (a.getDayOfWeek() == 6) { // friday
					line = line.replace("Thursday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Sunday", "");
					line = line.replace("Wednesday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Monday", "");
					line = line.replace("Tuesday", "");
				} else

				if (a.getDayOfWeek() == 7) { // saturday
					line = line.replace("Friday", "");
					line = line.replace("Thursday", "");
					line = line.replace("Saturday", "");
					line = line.replace("Sunday", "");
					line = line.replace("Wednesday", "");
					line = line.replace("Monday", "");
					line = line.replace("Tuesday", "");
				}
				line = line.replace("Night", "");
				line = line.replace("Portsmouth, RI weather via rssWeather.com", "");

				while (titleStartIndex >= 0) {
					titleStartIndex = line.indexOf("<title>", titleEndIndex);
					if (titleStartIndex >= 0) {
						titleEndIndex = line.indexOf("</title>", titleStartIndex);
						sourceCode += line.substring(titleStartIndex + "<title>".length(), titleEndIndex) + "\n";
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