import java.awt.Color;

import javax.swing.JFrame;

public class Driver {
	
	public static void main(String[] args) {
		Game game = new Game();
		Panel window = new Panel(game);
		//Board board = window.getBoard();
		JFrame page = new JFrame();
		page.setSize(300, 700);
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setBackground(Color.WHITE);
		
		page.getContentPane().add(window);
		page.setVisible(true);
		page.repaint();
	}
}
