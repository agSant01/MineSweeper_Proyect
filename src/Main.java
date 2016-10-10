import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main {
	public static boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		JFrame myFrame = new JFrame("Color Grid");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(330, 330);

		MyPanel myPanel = new MyPanel();
		myFrame.add(myPanel);

		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);
		
		myFrame.setVisible(true);
		
		while(!flag){
			//Loop until a mine is Found
			Thread.sleep(1);
		}
		JOptionPane.showMessageDialog(null , "Mine Exploded!");
		System.exit(0);
	}
}