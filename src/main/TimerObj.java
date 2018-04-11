package main;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ZackB
 *
 */
public class TimerObj {
	private static Date now = new Date();

	public TimerObj() {
		
	}
	
	public static long getCurrentTimeSec() {
		return System.currentTimeMillis();
	}

	public int getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		return calendar.get(Calendar.DAY_OF_WEEK); // the day of the week in numerical format
	}

	public static void main(String[] args) throws InterruptedException {

		// SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of
		// the week abbreviated
		// System.out.println(simpleDateformat.format(now));
		//
		// simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week
		// spelled out completely
		// System.out.println(simpleDateformat.format(now));
		//
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // the day of the week in numerical format
		LocalDateTime date = LocalDateTime.now();
		int seconds = date.toLocalTime().toSecondOfDay();
		System.out.println(seconds);
		Thread.sleep(2000);
		System.out.println(date.toLocalTime().toSecondOfDay());
	}
}