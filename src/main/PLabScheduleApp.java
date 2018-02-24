package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setName(room);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PLabScheduleApp.class.getResource(resourcePath)));
		label.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPane.add(label);
	}

	private void switchClass() {
		// TODO Auto-generated method stub
		switch (classID) {
		case 1:
			resourcePath = "";
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		default:

		}
	}

	public void addFilepath(String room) {
		resourcePath = room;
	}

	public void addName(String roomName) {
		room = roomName;
	}
	
}
