package main;

import com.sun.javafx.application.PlatformImpl;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * SwingFXWebView
 */
@SuppressWarnings("restriction")
public class SwingFXWebView extends JFrame {
	private static final long serialVersionUID = 1L;
	private Stage stage;
	private WebView browser;
	private JFXPanel jfxPanel;
	private JButton swingButton;
	private WebEngine webEngine;
	private String link0;

	public SwingFXWebView(String link) {
		initComponents();
		link0 = link;
	}

	public static void main(String[] args) {
		// Run this later:
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				final JFrame frame = new JFrame();

				frame.getContentPane().add(new SwingFXWebView("http://www.google.com"));

				frame.setMinimumSize(new Dimension(1280, 720));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

	private void initComponents() {

		jfxPanel = new JFXPanel();
		createScene();

		setLayout(new BorderLayout());
		add(jfxPanel, BorderLayout.CENTER);

		swingButton = new JButton();
		swingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						webEngine.reload();
					}
				});
			}
		});
		swingButton.setText("Reload");

		add(swingButton, BorderLayout.SOUTH);
	}

	/**
	 * createScene
	 * 
	 * Note: Key is that Scene needs to be created and run on "FX user thread" NOT
	 * on the AWT-EventQueue Thread
	 * 
	 */
	private void createScene() {
		PlatformImpl.startup(new Runnable() {
			@Override
			public void run() {

				stage = new Stage();

				stage.setTitle("Mini Browser");
				stage.setResizable(true);
				stage.setAlwaysOnTop(true);
				Group root = new Group();
				Scene scene = new Scene(root, 1270, 720);
				stage.setHeight(720);
				stage.setWidth(1280);
				stage.setScene(scene);

				// Set up the embedded browser:
				browser = new WebView();
				browser.setPrefSize(1280, 720);
				webEngine = browser.getEngine();
				webEngine.load(link0);

				ObservableList<Node> children = root.getChildren();
				children.add(browser);

				jfxPanel.setScene(scene);
			}
		});
	}
}