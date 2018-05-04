/**
 * 
 */
package main;


import java.util.TimerTask;
import java.util.Timer;

/**
 * @author ZackB
 *
 */
public class Main {
	public static Thread t;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main_Swing main = new Main_Swing();
		t = new Thread(main);
		t.start();

		Timer timer = new Timer();
        timer.schedule(new Timer0(), 1000 * 60 * 60 * 24, 1000 * 60 * 60 * 24); // replace 2000 with 24hr converted to millisec
	}

	private static class Timer0 extends TimerTask {
		public void run() {
			if (t.isAlive()) {
				t.interrupt();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Main_Swing main = new Main_Swing();
				t = new Thread(main);
				t.start();
			}
		}
	}

}
