package main;

import java.text.SimpleDateFormat;
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
	
	public long getCurrentTimeSec() {
		return System.nanoTime() / 1000000000;
	}

	public int getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		return calendar.get(Calendar.DAY_OF_WEEK); // the day of the week in numerical format
	}

	public static void main(String[] args) {

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
	}
}
