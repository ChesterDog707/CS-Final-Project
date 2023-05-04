import java.awt.Color;
import java.awt.Graphics;

public class Board {
	int[][] board = new int[10][20];
	final static Color[] colors = {new Color(61, 255, 236), new Color(15, 4, 222), new Color(240, 141, 12), new Color(255, 247, 0), new Color(11, 227, 0), new Color(219, 0, 235), new Color(235, 0, 0)};
	//test comment
	
	public int[][] getBoard() {
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}

	public Board() {
		for(int i = 0; i < 10; i++) 
			for(int j = 0; j < 20; j ++)
				board[i][j] = 0;
	}
	
	public void drawBoard(Graphics g) {
		
	}
	public void clearLines() {
		
	}
	public int checkForLines() {
		int output = 0;
		return output;
	}
}
