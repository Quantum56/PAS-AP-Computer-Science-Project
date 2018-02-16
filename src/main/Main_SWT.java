package main;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CLabel;

public class Main_SWT {

	protected Shell shlPasScienceBuilding;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main_SWT window = new Main_SWT();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlPasScienceBuilding.open();
		shlPasScienceBuilding.layout();
		while (!shlPasScienceBuilding.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPasScienceBuilding = new Shell();
		shlPasScienceBuilding.setTouchEnabled(true);
		shlPasScienceBuilding.setImage(SWTResourceManager.getImage(Main_SWT.class, "/img/PAS Science Building Map-1.jpg"));
		shlPasScienceBuilding.setSize(800, 600);
		shlPasScienceBuilding.setText("PAS Science Building");
		shlPasScienceBuilding.setLayout(null);
		
		Menu menu = new Menu(shlPasScienceBuilding, SWT.BAR);
		shlPasScienceBuilding.setMenuBar(menu);
		
		MenuItem mntmTest = new MenuItem(menu, SWT.NONE);
		mntmTest.setText("Test1");
		
		CLabel label = new CLabel(shlPasScienceBuilding, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		label.setImage(SWTResourceManager.getImage(Main_SWT.class, "/img/Science Building Map-1.jpg"));
		label.setBounds(10, 10, 764, 521);
		formToolkit.adapt(label);
		formToolkit.paintBordersFor(label);
		label.setText("");

	}
}
