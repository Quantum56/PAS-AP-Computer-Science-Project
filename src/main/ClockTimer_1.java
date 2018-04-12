package main;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author ZackB
 * @see java.lang.Runnable#run()
 */
public class ClockTimer implements Runnable {
	private final int normalBlock = 0; // normal block size in milliseconds
	private final int extendedBlock = 0; // extended block size in milliseconds
	private final int conferenceBlock = 0; // conference block size in milliseconds
	private static final int[] mondayTimes = {};
	private static final int[] tuesdayTimes = {};
	private static final int[] wednesdayTimes = {};
	private static final int[] thursdayTimes = {};
	private static final int[] fridayTimes = {};
	private static final int[] saturdayTimes = {};
	public static int[] currentArr = {};
	private int ClockTickAmt = 0;
	private int iterator = 0;
	private int dayOfWeek;

	private final int delay = 300000;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public void startScheduleTask() {
		/**
		 * not using the taskHandle returned here, but it can be used to cancel the
		 * task, or check if it's done (for recurring tasks, that's not going to be very
		 * useful)
		 */
		final ScheduledFuture<?> taskHandle = scheduler.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				if (ClockTickAmt * delay == currentArr[iterator]) {
					// insert image changer here
					System.out.println("Seconds Passed: " + iterator);
					iterator++;
				}
				ClockTickAmt++;
			}
		}, 0, 5, TimeUnit.MINUTES);
		taskHandle.cancel(false);
	}

	public void setDay() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1: // Sunday
			currentArr = mondayTimes;
			break;
		case 2: // Monday
			currentArr = mondayTimes;
			break;
		case 3: // Tuesday
			currentArr = tuesdayTimes;
			break;
		case 4: // Wednesday
			currentArr = wednesdayTimes;
			break;
		case 5: // Thursday
			currentArr = thursdayTimes;
			break;
		case 6: // Friday
			currentArr = fridayTimes;
			break;
		case 7: // Saturday
			currentArr = saturdayTimes;
			break;
		default: // optional
			currentArr = mondayTimes;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ClockTimer timer0 = new ClockTimer();
		timer0.startScheduleTask();
	}

}