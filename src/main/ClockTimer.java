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
	public static final int[] mondayTimes = {};
	public static final int[] tuesdayTimes = {};
	public static final int[] wednesdayTimes = {};
	public static final int[] thursdayTimes = {};
	public static final int[] fridayTimes = {};
	public static final int[] saturdayTimes = {};
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