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
	public int[] currentTimes;
	public final int[] mondayTimes = { 29700, 33000, 42300, 45300, 50400, 53700 }; // 8:15, 9:05, 11:45, 12:35, 2:00, 2:55
	public final int[] tuesdayTimes = { 29700, 33000, 42300, 45300, 48900, 52200 }; // 8:15, 9:05, 11:45, 12:35, 1:30, 2:30
	public final int[] wednesdayTimes = { 29700, 33000, 37800, 41100, 44400 }; // 8:15, 9:05, 10:30, 11:25, 12:20
	public final int[] thursdayTimes = { 29700, 33000, 42300, 47100, 48900 }; // 8:15, 9:05, 10:30, 11:45, 12:35, 1:30, 2:30
	public final int[] fridayTimes = { 29700, 33000, 42300, 45300, 50400, 53700 }; // 8:15, 9:05, 11:45, 12:35, 2:00, 2:55
	public final int[] saturdayTimes = { 29700, 33000, 36000, 42600 }; // 8:15, 9:05, 10:00, 10:55, 11:50

	public String[] currentSch;
	public final String[] mondaySch = { "E", "C", "G", "F", "A" };
	public final String[] tuesdaySch = { "B", "D", "F", "G", "E" };
	public final String[] wednesdaySch = { "C", "B", "D", "A" };
	public final String[] thursdaySch = { "A", "E", "G", "F", "C" };
	public final String[] fridaySch = { "D", "E", "F", "G", "B" };
	public final String[] saturdaySch = { "A", "B", "C", "D" };

	public TimerObj() {

	}

	public long getSeconds() {
		ZonedDateTime now = ZonedDateTime.now();
		ZonedDateTime midnight = now.truncatedTo(ChronoUnit.DAYS);
		Duration duration = Duration.between(midnight, now);
		long secondsPassed = duration.getSeconds();
		return secondsPassed;
	}

	public void setDay() {
		dayOfWeek = getDayOfWeek();
		if (dayOfWeek == 1) {
			currentTimes = mondayTimes;
			currentSch = mondaySch;
		} else
		// Monday
		if (dayOfWeek == 2) {
			currentTimes = mondayTimes;
			currentSch = mondaySch;
		} else
		// Tuesday
		if (dayOfWeek == 3) {
			currentTimes = tuesdayTimes;
			currentSch = tuesdaySch;
		} else
		// Wednesday
		if (dayOfWeek == 4) {
			currentTimes = wednesdayTimes;
			currentSch = wednesdaySch;
		} else
		// Thursday
		if (dayOfWeek == 5) {
			currentTimes = thursdayTimes;
			currentSch = thursdaySch;
		} else
		// Friday
		if (dayOfWeek == 6) {
			currentTimes = fridayTimes;
			currentSch = fridaySch;
		} else
		// Saturday
		if (dayOfWeek == 7) {
			currentTimes = saturdayTimes;
			currentSch = saturdaySch;
		} else
		// optional
		if (dayOfWeek != 0) {
			currentTimes = mondayTimes;
			currentSch = mondaySch;
		}
	}

	public long getCurrentNanos() {
		return System.nanoTime() / 1000000000;
	}

	public int getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, 0);
		return calendar.get(Calendar.DAY_OF_WEEK); // the day of the week in numerical format
	}
	
	public String getDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, 0);
		Date date = calendar.getTime();             
		SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");          
		String inActiveDate = null;
		inActiveDate = format1.format(date);
		return inActiveDate;
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
		calendar.add(Calendar.DATE, 0);
		Date date = calendar.getTime();             
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");          
		String inActiveDate = null;
		inActiveDate = format1.format(date);
		System.out.println(inActiveDate.replaceAll("-", "/"));
//		System.out.println(getDayOfWeek()); // the day of the week in numerical format
		// used for testing only
	}
}