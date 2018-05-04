package main;

import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.net.URL;

/**
 * Simple illustration of GUI construction for a rudimentary web-browser. As an
 * exercise add code and data structures so that the forward and back buttons
 * work appropriately (or modify the class via extension).
 * <P>
 * When creating a browser, client code should set the size of of the frame
 * (note that Browser extends JFrame).
 * <P>
 * 
 * <PRE>
 * Browser b = new Browser();
 * b.setSize(400, 400);
 * b.setVisible(true);
 * </PRE>
 *
 * @author Owen Astrachan
 */

public class JBrowserInit extends JFrame {
	private static final long serialVersionUID = 1L;
	private JEditorPane myEditor; // displays web page
	private JLabel myNextURL; // if link clicked, go here
	private JTextField myURLDisplay; // user-entered url
	private JButton myBackButton; // generates call of doBack()
	private JButton myNextButton; // generates call of doNext()

	/**
	 * Construct the web browser, calling code should set size of frame.
	 */
	public JBrowserInit() {
		myEditor = new JEditorPane();
		myEditor.setEditable(false); // allows links to be followed
		initGui();
	}

	private JPanel makeButtons() {
		myBackButton = new JButton("Back");
		myNextButton = new JButton("Next");

		// add listener so backButton calls doBack()
		myBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doBack();
			}
		});

		// add listener so nextButton calls doNext()
		myNextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doNext();
			}
		});

		// create panel with back at left, next at right, return it
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(myBackButton, BorderLayout.WEST);
		panel.add(myNextButton, BorderLayout.EAST);
		return panel;
	}

	/**
	 * called when back button pressed
	 */
	protected void doBack() {
		JOptionPane.showMessageDialog(null, "you pressed the back button");
	}

	/**
	 * called when next button pressed
	 */
	protected void doNext() {
		JOptionPane.showMessageDialog(null, "you pressed the next button");
	}

	/**
	 * Make user-entered URL/text field and back/next buttons
	 */
	private JPanel makeTopPanel() {
		myURLDisplay = new JTextField(35);
		JLabel topLabel = new JLabel("url/address ");
		JPanel urlPanel = new JPanel(new BorderLayout());
		urlPanel.add(topLabel, BorderLayout.WEST);
		urlPanel.add(myURLDisplay, BorderLayout.CENTER);
		urlPanel.add(makeButtons(), BorderLayout.NORTH);

		// if user presses return, load/show the URL
		myURLDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPage(e.getActionCommand());
			}
		});

		return urlPanel;
	}

	/**
	 * Make the panel where "would-be" clicked URL is displayed
	 */
	private JPanel makeBottomPanel() {
		// bottomLabel is a hack. Because the myNextURL label
		// is initially empty it doesn't show up, the bottomLabel does

		myNextURL = new JLabel();
		JLabel bottomLabel = new JLabel(" ");
		JPanel bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.add(bottomLabel, BorderLayout.WEST);
		bottomPanel.add(myNextURL, BorderLayout.CENTER);
		return bottomPanel;
	}

	private void initGui() {
		JPanel topPanel = makeTopPanel();
		JPanel bottomPanel = makeBottomPanel();

		// make editor respond to link-clicks/mouse-overs, make it scroll
		myEditor.addHyperlinkListener(new LinkFollower());
		JScrollPane scroller = new JScrollPane(myEditor);

		// add components to frame, make it exit when closed
		// default for contentPane is BorderLayout, use this

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(topPanel, BorderLayout.NORTH);
		this.getContentPane().add(scroller, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		setTitle("Duke/108 Wowser-Browser");
	}

	/**
	 * displays the url the user enters and echo the url in the textfield (even if
	 * it came from there!) the echo makes it so link-clicking shows the URL
	 */
	private void showPage(String url) {
		try {
			myEditor.setPage(url);
			myURLDisplay.setText(url);
		} catch (Exception e) {
			myEditor.setContentType("text/html");
			myEditor.setText("<html>Could not load " + url + "</html>");
		}
	}

	/**
	 * Show where link would take us if clicked
	 */

	private void showNextURL(String s) {
		myNextURL.setText(s);
	}

	/**
	 * Inner class to deal with link-clicks and mouse-overs
	 */

	private class LinkFollower implements HyperlinkListener {
		public void hyperlinkUpdate(HyperlinkEvent evt) {
			if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				// user clicked a link, load it and show it
				URL url = null;
				try {
					url = evt.getURL();
					showPage(url.toString());
				} catch (Exception e) {
					System.out.println("loading problem for " + url + " " + e);
				}
			} else if (evt.getEventType() == HyperlinkEvent.EventType.ENTERED) {
				// user moused-into a link, show what would load

				try {
					showNextURL(evt.getURL().toString());
				} catch (Exception e) {
					// nothing to do, if URL fails, don't pre-announce
				}
			} else if (evt.getEventType() == HyperlinkEvent.EventType.EXITED) {
				// user moused-out of a link, erase what was shown

				showNextURL("");
			}
		}
	}

	public static void main(String args[]) {
		JBrowserInit b = new JBrowserInit();
		b.setSize(600, 600);
		b.setLocation(10, 20);
		b.setVisible(true);
	}
}