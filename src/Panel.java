import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel{
	Board board;
	
	public Panel(Board board) {
		this.board = board;
	}
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}

	public void paintComponent(Graphics g) {
		board.drawBoard(g);
	}
}
