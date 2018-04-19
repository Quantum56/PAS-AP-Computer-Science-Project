package main;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ZackB
 *
 */
public class TimerObj {
	private static Date now = new Date();
	
	public int dayOfWeek;
	public static int[] currentTimes;
	public final int[] mondayTimes = {};
	public final int[] tuesdayTimes = {};
	public final int[] wednesdayTimes = {};
	public final int[] thursdayTimes = {};
	public final int[] fridayTimes = {};
	public final int[] saturdayTimes = {};

	public static String[] currentSch;
	public final String[] mondaySch = {};
	public final String[] tuesdaySch = {};
	public final String[] wednesdaySch = {};
	public final String[] thursdaySch = {};
	public final String[] fridaySch = {};
	public final String[] saturdaySch = {};
	
	public TimerObj() {
		
	}
	
	public static long getSeconds() {
		ZonedDateTime now = ZonedDateTime.now();
		ZonedDateTime midnight = now.truncatedTo(ChronoUnit.DAYS);
		Duration duration = Duration.between(midnight, now);
		long secondsPassed = duration.getSeconds();
		return secondsPassed;
	}
	
	public void setDay() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1: // Sunday
			currentTimes = mondayTimes;
			break;
		case 2: // Monday
			currentTimes = mondayTimes;
			break;
		case 3: // Tuesday
			currentTimes = tuesdayTimes;
			break;
		case 4: // Wednesday
			currentTimes = wednesdayTimes;
			break;
		case 5: // Thursday
			currentTimes = thursdayTimes;
			break;
		case 6: // Friday
			currentTimes = fridayTimes;
			break;
		case 7: // Saturday
			currentTimes = saturdayTimes;
			break;
		default: // optional
			currentTimes = mondayTimes;
		}
	}
	
	public long getCurrentNanos() {
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
		System.out.println(getSeconds());
	}
}