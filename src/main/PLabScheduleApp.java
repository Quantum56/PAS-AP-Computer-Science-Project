package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PLabScheduleApp frame = new PLabScheduleApp(0);
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
		setBounds(100, 100, 800, 600);
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
		// TODO Auto-generated method stub
		switch (classID) {
		case 1:
			resourcePath = "/img/Science Building Map-1.jpg"; // CLab
		case 2:
			resourcePath = "/img/Science Building Map-1.jpg"; // SC2
		case 3:
			resourcePath = "/img/Science Building Map-1.jpg"; // PhysLab
		case 4:
			resourcePath = "/img/Science Building Map-1.jpg"; // ChemLab
		case 5:
			resourcePath = "/img/Science Building Map-1.jpg"; // SC1
		case 6:
			resourcePath = "/img/Science Building Map-1.jpg"; // BLab
		default:
			resourcePath = "/img/Science Building Map-1.jpg";

		}
	}

	public void addFilepath(String room) {
		resourcePath = room;
	}

	public void addName(String roomName) {
		room = roomName;
	}
	
}
