package main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Main_Swing implements Runnable {

	private JFrame frmPasScienceBuilding;

	private String currentClass7 = "RLH Schedule";
	public String currentClass1 = "Computer Lab Schedule";
	public String currentClass2 = "Physics Classroom Schedule";
	public String currentClass3 = "Physics Lab Schedule";
	public String currentClass4 = "Chemistry Lab Schedule";
	public String currentClass5 = "Chemistry Classroom Schedule";
	public String currentClass6 = "Biology Classroom Schedule";

	private static final int[] button1_768 = { 156, 213, 300, 117 };
	private static final int[] button2_768 = { 554, 213, 280, 117 };
	private static final int[] button3_768 = { 970, 213, 250, 117 };
	private static final int[] button4_768 = { 850, 630, 417, 130 };
	private static final int[] button5_768 = { 435, 630, 280, 130 };
	private static final int[] button6_768 = { 155, 630, 280, 130 };
	private static final int[] button7_768 = { 444, 349, 480, 250 };
	private static final int[] button1_1080 = {};
	private static final int[] button2_1080 = {};
	private static final int[] button3_1080 = {};
	private static final int[] button4_1080 = {};
	private static final int[] button5_1080 = {};
	private static final int[] button6_1080 = {};
	private static final int[] button7_1080 = {};
	private int[] current1;
	private int[] current2;
	private int[] current3;
	private int[] current4;
	private int[] current5;
	private int[] current6;
	private int[] current7;

	public JPanel jButtonPanel = new JPanel();
	public JLabel backLabel = new JLabel("");

	public static int ScrWidth;
	public static int ScrHeight;

	/**
	 * Launch the application.
	 * 
	 * @author ZackB, DaveyA, BrendanK
	 * @version 0.2.0
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Main_Swing window = new Main_Swing();
					window.frmPasScienceBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Swing() {
		init();
	}

	public void switchBackground() {
		TimerObj a = new TimerObj();
		a.setDay();
		// int day = a.getDayOfWeek();

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				TimerObj b = new TimerObj();
				for (int i = 0; i < a.currentTimes.length - 1; i++) {
					if (a.currentTimes[a.currentTimes.length - 1] > b.getSeconds() || a.currentTimes[0] > b.getSeconds()) {
						lblChg("/img/Science Building Map-1.jpg");
					}
					if (a.currentTimes[i] < b.getSeconds() && a.currentTimes[i + 1] > b.getSeconds()) {
						if (a.currentSch[i] == "A") {
							lblChg("/img/A Block-1.jpg");
						} else if (a.currentSch[i] == "B") {
							lblChg("/img/B Block-1.jpg");
						} else if (a.currentSch[i] == "C") {
							lblChg("/img/C Block-1.jpg");
						} else if (a.currentSch[i] == "D") {
							lblChg("/img/D Block-1.jpg");
						} else if (a.currentSch[i] == "E") {
							lblChg("/img/E Block-1.jpg");
						} else if (a.currentSch[i] == "F") {
							lblChg("/img/F Block-1.jpg");
						} else if (a.currentSch[i] == "G") {
							lblChg("/img/G Block-1.jpg");
						}
					}
				}
				b.getSeconds();
			}
		};
		Timer timer = new Timer(5000, taskPerformer); // restarts every minute 120000
		timer.setRepeats(true);
		timer.start();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void init() {
		frmPasScienceBuilding = new JFrame();
		frmPasScienceBuilding.setType(Type.UTILITY);
		frmPasScienceBuilding.setBackground(Color.DARK_GRAY);
		frmPasScienceBuilding.setAlwaysOnTop(false);
		frmPasScienceBuilding.setForeground(Color.DARK_GRAY);
		frmPasScienceBuilding.getContentPane().setForeground(Color.DARK_GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ScrWidth = (int) screenSize.getWidth();
		ScrHeight = (int) screenSize.getHeight();
		frmPasScienceBuilding.setSize(ScrWidth, ScrHeight);
		Image dimg = getBufferedImage("/img/Science Building Map-1.jpg", ScrWidth, ScrHeight);
		frmPasScienceBuilding.getContentPane().setLayout(null);

		switchButtons();
		backLabel.setBounds(0, 100, ScrWidth, ScrHeight);
		backLabel.setIcon(new ImageIcon(dimg));
		jButtonPanel.setLayout(null);
		jButtonPanel.setVisible(true);
		jButtonPanel.setBounds(0, 0, ScrWidth, ScrHeight);
		JButtonInit button1CLAB = new JButtonInit(current1[0], current1[1], current1[2], current1[3], 1, Color.white,
				currentClass1);
		JButtonInit button2SC2 = new JButtonInit(current2[0], current2[1], current2[2], current2[3], 2, Color.black,
				currentClass2);
		JButtonInit button3PLAB = new JButtonInit(current3[0], current3[1], current3[2], current3[3], 3, Color.black,
				currentClass3);
		JButtonInit button4ChLAB = new JButtonInit(current4[0], current4[1], current4[2], current4[3], 4, Color.black,
				currentClass4);
		JButtonInit button5SC1 = new JButtonInit(current5[0], current5[1], current5[2], current5[3], 5, Color.white,
				currentClass5);
		JButtonInit button6BLAB = new JButtonInit(current6[0], current6[1], current6[2], current6[3], 6, Color.white,
				currentClass6);
		JButtonInit button7RLH = new JButtonInit(current7[0], current7[1], current7[2], current7[3], 7, Color.white,
				currentClass7);
		button1CLAB.setActive(true);
		button2SC2.setActive(true);
		button3PLAB.setActive(true);
		button4ChLAB.setActive(true);
		button5SC1.setActive(true);
		button6BLAB.setActive(true);
		button7RLH.setActive(true);
		jButtonPanel.setOpaque(false);
		frmPasScienceBuilding.getContentPane().add(jButtonPanel);
		frmPasScienceBuilding.getContentPane().add(backLabel);

		JLabel lblPortsmouthAbbeySchool = new JLabel("Portsmouth Abbey School Science Building");
		lblPortsmouthAbbeySchool.setVerticalAlignment(SwingConstants.TOP);
		lblPortsmouthAbbeySchool.setForeground(new Color(200, 0, 0));
		lblPortsmouthAbbeySchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortsmouthAbbeySchool.setFont(new Font("Serif", Font.PLAIN, 65));
		lblPortsmouthAbbeySchool.setBounds(-250, 0, 1920, 100);
		frmPasScienceBuilding.getContentPane().add(lblPortsmouthAbbeySchool);

		MovingText textFrame = new MovingText("http://rss.cnn.com/rss/cnn_us.rss%22");
		textFrame.setSize(ScrWidth, 20);
		textFrame.setBounds(0, 100, ScrWidth, 70);
		textFrame.setVisible(true);
		frmPasScienceBuilding.getContentPane().add(textFrame);

		// MovingText textFrame0 = new
		// MovingText("http://rss.cnn.com/rss/cnn_us.rss%22");
		// textFrame.setSize(1366, 20);
		// textFrame.setBounds(0, 150, ScrWidth, 70);
		// textFrame.setVisible(true);
		// frmPasScienceBuilding.getContentPane().add(textFrame0);

		JLabel label1 = new JLabel();
		label1.setText("Tap on a classroom to open its schedule: ");
		label1.setFont(new Font("Lato", Font.PLAIN, 20));
		label1.setBounds((backLabel.getWidth() / 2) - 190, 71, 650, 35);
		label1.setVisible(true);
		backLabel.add(label1);

		frmPasScienceBuilding.setTitle("PAS Science Building");
		frmPasScienceBuilding.setBounds(100, 100, 1920, 1080);
		frmPasScienceBuilding.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmPasScienceBuilding.setUndecorated(true);
		frmPasScienceBuilding.setVisible(true);
		frmPasScienceBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Clock clock = new Clock();
		JPanel clock0 = clock.getObj();
		clock0.setBounds(0, 20, 142, 51);
		clock0.setVisible(true);
		frmPasScienceBuilding.getContentPane().add(clock0);

		JMenuBar menuBar = new JMenuBar();
		frmPasScienceBuilding.setJMenuBar(menuBar);

		JLabel dateLbl = new JLabel();
		TimerObj a = new TimerObj();
		dateLbl.setVisible(true);
		dateLbl.setSize(50, 100);
		dateLbl.setText(a.getDate());
		dateLbl.setBounds(20, 30, 100, 100);
		frmPasScienceBuilding.getContentPane().add(dateLbl);

		JLabel weather = new JLabel();
		WeatherRSS w1 = new WeatherRSS();
		weather.setText(w1.readRSSFeed("http://www.rssweather.com/zipcode/02871/rss.php")); // w1.readRSSFeed("http://www.rssweather.com/zipcode/02871/rss.php")
		weather.setSize(100, 50);
		weather.setBounds(900, 50, 500, 50);
		backLabel.add(weather);

		JButton browser1 = new JButton();
		browser1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SwingFXWebView browser = new SwingFXWebView("https://www.portsmouthabbey.org/index.cfm");
							browser.setSize(1290, 720);
							browser.setAlwaysOnTop(true);
							browser.setVisible(true);
							browser.setResizable(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

		});
		browser1.setContentAreaFilled(false);
		browser1.setBorderPainted(true);
		browser1.setBounds(20, 30, 250, 80);
		browser1.setText("Portsmouth Abbey School Website");
		backLabel.add(browser1);
		switchBackground();
	}

	private void lblChg(String resPath) {
		Image dimg = getBufferedImage(resPath, ScrWidth, ScrHeight);
		backLabel.setIcon(new ImageIcon(dimg));
	}

	private void switchButtons() {
		// TODO Auto-generated method stub
		if (Toolkit.getDefaultToolkit().getScreenSize().getHeight() == 1080
				&& Toolkit.getDefaultToolkit().getScreenSize().getWidth() == 1920) {
//			current1 = button1_1080;
//			current2 = button2_1080;
//			current3 = button3_1080;
//			current4 = button4_1080;
//			current5 = button5_1080;
//			current6 = button6_1080;
//			current7 = button7_1080;
			current1 = button1_768;
			current2 = button2_768;
			current3 = button3_768;
			current4 = button4_768;
			current5 = button5_768;
			current6 = button6_768;
			current7 = button7_768;
		} else if (Toolkit.getDefaultToolkit().getScreenSize().getHeight() == 1080
				&& Toolkit.getDefaultToolkit().getScreenSize().getWidth() == 1920) {
			current1 = button1_768;
			current2 = button2_768;
			current3 = button3_768;
			current4 = button4_768;
			current5 = button5_768;
			current6 = button6_768;
			current7 = button7_768;
		} else {
			current1 = button1_768;
			current2 = button2_768;
			current3 = button3_768;
			current4 = button4_768;
			current5 = button5_768;
			current6 = button6_768;
			current7 = button7_768;
		}
	}

	public Image getBufferedImage(String filePath, int width, int height) {
		BufferedImage img = null;
		Image dimg = null;
		try {
			img = ImageIO.read(Main_Swing.class.getResource(filePath));
			dimg = img.getScaledInstance(frmPasScienceBuilding.getWidth(), frmPasScienceBuilding.getHeight(),
					Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dimg;
	}

	public void panelRefresh() {
		jButtonPanel.repaint();
	}

	public class MovingText extends JPanel implements ActionListener {
		private static final long serialVersionUID = 1L;
		private Font font = new Font("Arial", Font.BOLD, 16);
		JLabel label;

		public MovingText(String URL) {
			RSS rssobject = new RSS();
			rssobject.getRss(URL);

			label = new JLabel(rssobject.getRss(URL));
			this.add(label);
			this.setBackground(new Color(204, 0, 0));
			javax.swing.Timer timer = new javax.swing.Timer(200, this);
			timer.start();
		}

		public void actionPerformed(ActionEvent e) {
			String oldText = label.getText();
			String newText = oldText.substring(1) + oldText.substring(0, 1);
			label.setText(newText);
			label.setForeground(Color.WHITE);
			label.setFont(font);
		}
	}

	private class JButtonInit extends JButton {
		private static final long serialVersionUID = 1L;

		private Font Font0 = new Font("Arial", Font.BOLD, 14);

		public JButtonInit(int x, int y, int width, int height, int classID, Color color, String text) {
			JButton button0 = new JButton();
			button0.setFont(Font0);
			button0.setBounds(x, y, width, height);
			button0.setOpaque(true);
			button0.setBorderPainted(false);
			button0.setContentAreaFilled(false);
			button0.setLayout(null);
			addButton(button0);

			button0.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								PLabScheduleApp frame = new PLabScheduleApp(classID, text);
								frame.setVisible(true);
								frame.setAlwaysOnTop(true);
								revalidate();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					button0.setForeground(color);
					button0.setText("\nTouch to open room schedule");
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					button0.setText("");
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
				}
			});
		}

		public void addButton(JButton a) {
			jButtonPanel.add(a);
		}

		public void setActive(boolean a) {
			if (a) {
				this.setVisible(a);
			} else
				this.setVisible(a);
		}
	}

	public void run() {
		try {
			Main_Swing window = new Main_Swing();
			window.frmPasScienceBuilding.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
