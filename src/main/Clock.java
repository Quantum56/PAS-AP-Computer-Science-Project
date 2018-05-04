package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Clock extends JPanel {
	private static final long serialVersionUID = 1L;

	public Clock() {
	}

	public JPanel getObj() {
		DigitalClock1 myClock = new DigitalClock1();
		myClock.setVisible(true);
		return myClock;
	}

	static class DigitalClock1 extends JPanel {
		private static final long serialVersionUID = 1L;

		String stringTime;
		int hour, minute, second, ampm;

		String correctionHour = "";
		String correctionMinute = "";
		String correctionSecond = "";

		public void setStringTime(String xyz) {
			this.stringTime = xyz;
		}

		public int findMinimumBetweenTwoNumbers(int a, int b) {
			return (a <= b) ? a : b;
		}

		DigitalClock1() {

			Timer t1 = new Timer(1000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					repaint();
				}
			});
			t1.start();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			Calendar now = Calendar.getInstance();
			hour = now.get(Calendar.HOUR);
			int h = Math.abs(hour);
			h = (int) Math.floor(h / Math.pow(10, Math.floor(Math.log10(h))));
			if (h == 0) {
				String temp = Integer.toString(hour);
				int[] guess = new int[temp.length()];
				int last = guess[temp.length() - 1];
				hour = last;
			}
			minute = now.get(Calendar.MINUTE);
			second = now.get(Calendar.SECOND);
			ampm = now.get(Calendar.AM_PM);
			String am_pm;

			if (ampm == 1) {
				am_pm = "PM";
			} else {
				am_pm = "AM";
			}

			if (minute < 10) {
				this.correctionMinute = "0";
			}
			if (minute >= 10) {
				this.correctionMinute = "";
			}

			if (second < 10) {
				this.correctionSecond = "0";
			}
			if (second >= 10) {
				this.correctionSecond = "";
			}

			setStringTime(correctionHour + hour + ":" + correctionMinute + minute + ":" + correctionSecond + second
					+ " " + am_pm);
			g.setColor(Color.BLACK);
			int length = findMinimumBetweenTwoNumbers(this.getWidth(), this.getHeight());
			Font myFont = new Font("Arial", Font.PLAIN, 20);
			g.setFont(myFont);
			g.drawString(stringTime, (int) length / 6, length / 2);

		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(200, 200);
		}

	}

}