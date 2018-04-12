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

	private String currentClass7;
	public String currentClass1;
	public String currentClass2;
	public String currentClass3;
	public String currentClass4;
	public String currentClass5;
	public String currentClass6;

	public JPanel jButtonPanel = new JPanel();
	public JLabel backLabel = new JLabel("");
	
	static int ScrWidth;
	static int ScrHeight;

	private static int currentDay;

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
		frmPasScienceBuilding.setAlwaysOnTop(false);
		frmPasScienceBuilding.setForeground(Color.DARK_GRAY);
		frmPasScienceBuilding.getContentPane().setForeground(Color.DARK_GRAY);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ScrWidth = (int) screenSize.getWidth();
		ScrHeight = (int) screenSize.getHeight();
		frmPasScienceBuilding.setSize(ScrWidth, ScrHeight);
		Image dimg = getBufferedImage("/img/Science Building Map-1.jpg", ScrWidth, ScrHeight);
		frmPasScienceBuilding.getContentPane().setLayout(null);

		backLabel.setBounds(0, 100, ScrWidth, ScrHeight);
		backLabel.setIcon(new ImageIcon(dimg));
		jButtonPanel.setLayout(null);
		jButtonPanel.setVisible(true);
		jButtonPanel.setBounds(0, 0, ScrWidth, ScrHeight);
		JButtonInit button1CLAB = new JButtonInit(230, 300, 395, 123, 1, Color.white, currentClass1);
		JButtonInit button2SC2 = new JButtonInit(795, 300, 354, 123, 2, Color.black, currentClass2);
		JButtonInit button3PLAB = new JButtonInit(1390, 300, 297, 123, 3, Color.black, currentClass3);
		JButtonInit button4ChLAB = new JButtonInit(1270, 869, 417, 130, 4, Color.black, currentClass4);
		JButtonInit button5SC1 = new JButtonInit(614, 869, 375, 130, 5, Color.white, currentClass5);
		JButtonInit button6BLAB = new JButtonInit(230, 869, 384, 130, 6, Color.white, currentClass6);
		JButtonInit button7RLH = new JButtonInit(624, 496, 672, 288, 7, Color.white, currentClass7);
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
		lblPortsmouthAbbeySchool.setBounds(0, 0, 1920, 100);
		frmPasScienceBuilding.getContentPane().add(lblPortsmouthAbbeySchool);

		MovingText textFrame = new MovingText();
		textFrame.setSize(1920, 20);
		textFrame.setBounds(0, 100, 1920, 90);
		textFrame.setVisible(true);
		frmPasScienceBuilding.getContentPane().add(textFrame);

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

	private void chgBackground() throws InterruptedException {
		String rscPath;
		ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	Image dimg0 = getBufferedImage(rscPath, ScrWidth, ScrHeight);
            	backLabel.setIcon(new ImageIcon(dimg0));
            	frmPasScienceBuilding.getContentPane().add(backLabel);
            }
		};
		
		Timer a = new Timer(300000, taskPerformer);
		a.start();
		a.setRepeats(true);
		Thread.sleep(100);
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
		private Font font = new Font("Arial", Font.BOLD, 30);
		JLabel label;

		public MovingText() {
			RSS rssobject = new RSS();
			rssobject.getRss();

			label = new JLabel(rssobject.getRss());
			this.add(label);
			this.setBackground(new Color(204, 0, 0));
			javax.swing.Timer timer = new javax.swing.Timer(150, this);
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

		private Font Font0 = new Font("Arial", Font.BOLD, 18);

		public JButtonInit(int x, int y, int width, int height, int classID, Color color, String text) {
			JButton button0 = new JButton();
			button0.setFont(Font0);
			button0.setBounds(x, y, width, height);
			button0.setOpaque(true);
			button0.setBorderPainted(false);
			button0.setContentAreaFilled(false);
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
								PLabScheduleApp frame = new PLabScheduleApp(classID);
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

	@Override
	public void run() {
		try {
			Main_Swing window = new Main_Swing();
			window.frmPasScienceBuilding.setVisible(true);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
