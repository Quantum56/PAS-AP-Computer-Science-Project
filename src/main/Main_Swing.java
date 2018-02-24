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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Main_Swing {

	private JFrame frmPasScienceBuilding;
	private JButtonInit button1;
	private JButtonInit button2;
	private JButtonInit button3;
	private JButtonInit button4;
	private JButtonInit button5;
	private JButtonInit button6;
	private JButtonInit testButton;
	
	private String currentTest = "Hello world!";
	private String currentClass1;
	private String currentClass2;
	private String currentClass3;
	private String currentClass4;
	private String currentClass5;
	private String currentClass6;

	protected boolean appletIsRunning;

	/**
	 * Launch the application.
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void init() {
		frmPasScienceBuilding = new JFrame();
		frmPasScienceBuilding.setType(Type.UTILITY);
		frmPasScienceBuilding.setBackground(Color.DARK_GRAY);
		frmPasScienceBuilding.setAlwaysOnTop(true);
		frmPasScienceBuilding.setForeground(Color.DARK_GRAY);
		frmPasScienceBuilding.getContentPane().setForeground(Color.DARK_GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int ScrWidth = (int) screenSize.getWidth();
		final int ScrHeight = (int) screenSize.getHeight();
		frmPasScienceBuilding.setSize(ScrWidth, ScrHeight);
		BufferedImage img = cropImage("/img/Science Building Map-1.jpg", ScrWidth, ScrHeight);
		Image dimg = img.getScaledInstance(frmPasScienceBuilding.getWidth(), frmPasScienceBuilding.getHeight(),
				Image.SCALE_SMOOTH);
		frmPasScienceBuilding.getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(0, 100, ScrWidth, ScrHeight);
		label.setIcon(new ImageIcon(dimg));
		button1 = new JButtonInit(230, 300, 395, 123, 1, Color.white, currentClass1);
		button2 = new JButtonInit(795, 300, 354, 123, 2, Color.black, currentClass2);
		button3 = new JButtonInit(1390, 300, 297, 123, 3, Color.black, currentClass3);
		button4 = new JButtonInit(1270, 869, 417, 130, 4, Color.black, currentClass4);
		button5 = new JButtonInit(614, 869, 375, 130, 5, Color.white, currentClass5);
		button6 = new JButtonInit(230, 869, 384, 130, 6, Color.white, currentClass6);
		testButton = new JButtonInit(624, 496, 600, 288, 1, Color.white, currentTest);
		label.add(button1);
		label.add(button2);
		label.add(button3);
		label.add(button4);
		label.add(button5);
		label.add(button6);
		label.add(testButton);
		frmPasScienceBuilding.getContentPane().add(label);

		JLabel lblPortsmouthAbbeySchool = new JLabel("Portsmouth Abbey School Science Building");
		lblPortsmouthAbbeySchool.setVerticalAlignment(SwingConstants.TOP);
		lblPortsmouthAbbeySchool.setForeground(new Color(200, 0, 0));
		lblPortsmouthAbbeySchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortsmouthAbbeySchool.setFont(new Font("Serif", Font.PLAIN, 65));
		lblPortsmouthAbbeySchool.setBounds(0, 0, 1920, 100);
		frmPasScienceBuilding.getContentPane().add(lblPortsmouthAbbeySchool);

		frmPasScienceBuilding.setTitle("PAS Science Building");
		frmPasScienceBuilding.setBounds(100, 100, 1920, 1080);
		frmPasScienceBuilding.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmPasScienceBuilding.setUndecorated(true);
		frmPasScienceBuilding.setVisible(true);
		frmPasScienceBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmPasScienceBuilding.setJMenuBar(menuBar);

		this.clockLoop();
	}

	private void clockLoop() {
		LocalDateTime localNow = LocalDateTime.now();
		ZoneId currentZone = ZoneId.of("America/New_York");
		ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
		ZonedDateTime zonedNext8;
		zonedNext8 = zonedNow.withHour(8).withMinute(0).withSecond(0);
		if (zonedNow.compareTo(zonedNext8) > 0)
			zonedNext8 = zonedNext8.plusDays(1);

		Duration duration = Duration.between(zonedNow, zonedNext8);
		long initalDelay = duration.getSeconds();

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(new ClockTimer(), initalDelay, 24 * 60 * 60, TimeUnit.SECONDS);

	}

	public BufferedImage cropImage(String filePath, int width, int height) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(Main_Swing.class.getResource(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return img;
	}

	public void addButton(JButton a) {
		frmPasScienceBuilding.getContentPane().add(a);
	}

	private class JButtonInit extends JButton {
		private static final long serialVersionUID = 1L;

		private Font Font0 = new Font("Arial", Font.BOLD, 18);
		private int x_, y_, width_, height_, classID_;
		private Color color_;
		private String text_;

		public JButtonInit(int x, int y, int width, int height, int classID, Color color, String text) {
			x_ = x;
			y_ = y;
			width_ = width;
			height_ = height;
			classID_ = classID;
			color_ = color;
			text_ = text;
			JButton button0 = new JButton();
			button0.setFont(Font0);
			button0.setBounds(x, y, width, height);
			button0.setOpaque(true);
			button0.setBorderPainted(false);
			button0.setContentAreaFilled(true);
			button0.setLayout(null);
			button0.setText(text);
			addButton(button0);

			button0.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					EventQueue.invokeLater(new Runnable() {

						public void run() {
							try {
								if (!appletIsRunning) {
									appletIsRunning = true;
									PLabScheduleApp frame = new PLabScheduleApp(classID);
									frame.setVisible(true);
									frame.setAlwaysOnTop(true);
								}
							} catch (Exception e) {
								e.printStackTrace();
								appletIsRunning = false;
								reInit();
							}
						}
					});
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					button0.setForeground(color);
					button0.setText("\nClick to open room schedule");
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					button0.setText(text);
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
				}
			});
		}
		
		private void reInit() {
			JButtonInit ne = new JButtonInit(x_, y_, width_, height_, classID_, color_, text_);
			addButton(ne);
		}
	}

}
