package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PLabScheduleApp extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private String resourcePath;
	private static String room;
	private int scrWidth;
	private int scrHeight;
	private int classID = 0;
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Enter param id: (1-7)");
					int a = sc.nextInt();
					PLabScheduleApp frame = new PLabScheduleApp(a);
					frame.setVisible(true);
					frame.setAlwaysOnTop(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PLabScheduleApp(int id) {
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		scrHeight = scrSize.height;
		scrWidth = scrSize.width;
		classID = id;

		switchClass();

		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setName(room);

		JLabel label = new JLabel("");
		Image dimg = getBufferedImage(resourcePath, this.getWidth(), this.getHeight());
		label.setIcon(new ImageIcon(dimg));
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.setAlwaysOnTop(true);
		contentPane.add(label);
	}

	public Image getBufferedImage(String filePath, int width, int height) {
		BufferedImage img = null;
		Image dimg = null;
		try {
			img = ImageIO.read(PLabScheduleApp.class.getResource(filePath));
			dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dimg;
	}

	private void switchClass() {
		if (classID == 1)
			resourcePath = "/img/CLABFinal-1.jpg"; // CLab
		else if (classID == 2)
			resourcePath = "/img/SC2Final-2.jpg"; // SC2
		else if (classID == 3)
			resourcePath = "/img/PLABFinal-3.jpg"; // PhysLab
		else if (classID == 4)
			resourcePath = "/img/Science Building Map-1.jpg"; // ChemLab
		else if (classID == 5)
			resourcePath = "/img/SC1Final-5.jpg"; // SC1
		else if (classID == 6)
			resourcePath = "/img/BLABFinal-6.jpg"; // BLab
		else if (classID == 7)
			resourcePath = "/img/RLHFinal.jpg";
		else {
			System.err.println("errorneous parameter id");
		}
	}

	public void addFilepath(String room) {
		resourcePath = room;
	}

	public void addName(String roomName) {
		room = roomName;
	}

}
