/**
 * 
 */
package main;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

/**
 * @author ZackB
 *
 */
public class Main {
	public static volatile Thread t;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Main_Swing main = new Main_Swing();
		// t = new Thread(main);
		// t.start();

		Timer timer = new Timer();
		Calendar date = new GregorianCalendar();
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 1);
		Date midnightTonight = date.getTime();

		timer = new Timer(true);
		timer.schedule(new Task(), midnightTonight, TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // replace 2000 with 24hr converted to millisec
	}

	private static class Task extends TimerTask {
		public void run() {
			if (t != null) {
				t = null;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Main_Swing window = new Main_Swing();
			t = new Thread(window);
			t.start();
		}
	}

}
