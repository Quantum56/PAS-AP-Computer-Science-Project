/**
 * 
 */
package main;

/**
 * @author ZackB
 *
 */
public class Main {
	public static Thread t;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		t = new Thread(new Main_Swing());
		t.start();
		
	}

}
