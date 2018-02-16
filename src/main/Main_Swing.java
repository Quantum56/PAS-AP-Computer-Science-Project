package main;

import java.awt.EventQueue;
import java.awt.Image;
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

public class Main_Swing {

	private JFrame frmPasScienceBuilding;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPasScienceBuilding = new JFrame();
		frmPasScienceBuilding.setType(Type.UTILITY);
		frmPasScienceBuilding.setBackground(Color.DARK_GRAY);
		frmPasScienceBuilding.setAlwaysOnTop(true);
		frmPasScienceBuilding.setForeground(Color.DARK_GRAY);
		frmPasScienceBuilding.getContentPane().setForeground(Color.DARK_GRAY);
		frmPasScienceBuilding.getContentPane().setLayout(new BorderLayout(0, 0));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int ScrWidth = (int) screenSize.getWidth();
		final int ScrHeight = (int) screenSize.getHeight();
		frmPasScienceBuilding.setSize(ScrWidth, ScrHeight);
		BufferedImage img = null;
		try {
			img = ImageIO.read(Main_Swing.class.getResource("/img/Science Building Map-1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(frmPasScienceBuilding.getWidth(), frmPasScienceBuilding.getHeight(), Image.SCALE_SMOOTH);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(dimg));
		frmPasScienceBuilding.getContentPane().add(label, BorderLayout.CENTER);

		JLabel lblPortsmouthAbbeySchool = new JLabel("Portsmouth Abbey School Science Building");
		lblPortsmouthAbbeySchool.setForeground(new Color(204, 0, 0));
		lblPortsmouthAbbeySchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortsmouthAbbeySchool.setFont(new Font("Serif", Font.PLAIN, 65));
		lblPortsmouthAbbeySchool.setBounds(0, 0, ScrWidth, ScrHeight);
		frmPasScienceBuilding.getContentPane().add(lblPortsmouthAbbeySchool, BorderLayout.NORTH);
		frmPasScienceBuilding.setTitle("PAS Science Building");
		frmPasScienceBuilding.setBounds(100, 100, 721, 549);
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
	        ZonedDateTime zonedNext5 ;
	        zonedNext5 = zonedNow.withHour(8).withMinute(0).withSecond(0);
	        if(zonedNow.compareTo(zonedNext5) > 0)
	            zonedNext5 = zonedNext5.plusDays(1);

	        Duration duration = Duration.between(zonedNow, zonedNext5);
	        long initalDelay = duration.getSeconds();

	        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);            
	        scheduler.scheduleAtFixedRate(new ClockTimer(), initalDelay, 24*60*60, TimeUnit.SECONDS);
		
	}
}
